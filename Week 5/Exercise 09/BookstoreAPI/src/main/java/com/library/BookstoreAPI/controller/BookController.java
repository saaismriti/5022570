package com.library.BookstoreAPI.controller;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.library.BookstoreAPI.dto.BookDTO;
import com.library.BookstoreAPI.exception.BadRequestException;
import com.library.BookstoreAPI.exception.BookNotFoundException;
import com.library.BookstoreAPI.mapper.BookMapper;
import com.library.BookstoreAPI.model.Book;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();
    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @GetMapping("/search")
    public List<BookDTO> searchBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String author) {
        return books.stream()
                .filter(book -> (title == null || book.getTitle().toLowerCase().contains(title.toLowerCase())) &&
                                (author == null || book.getAuthor().toLowerCase().contains(author.toLowerCase())))
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@Valid @RequestBody BookDTO bookDTO) {
        if (bookDTO.getId() <= 0) {
            throw new BadRequestException("Invalid book ID");
        }
        Book book = bookMapper.toEntity(bookDTO);
        books.add(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookCreated");
        return new ResponseEntity<>(bookMapper.toDTO(book), headers, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable int id) {
        Book book = books.stream()
                .filter(b -> b.getId() == id)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));

        BookDTO bookDTO = bookMapper.toDTO(book);

        // Add HATEOAS links
        /*
       bookDTO.add(linkTo(methodOn(BookController.class).getBookById(id)).withSelfRel());
        bookDTO.add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("all-books"));
        bookDTO.add(linkTo(methodOn(BookController.class).deleteBook(id)).withRel("delete-book"));
         bookDTO.add(linkTo(methodOn(BookController.class).updateBook(id, bookDTO)).withRel("update-book").withType("PUT"));
        
         */
        bookDTO.add(linkTo(methodOn(BookController.class).getBookById(id)).withSelfRel());
        bookDTO.add(linkTo(methodOn(BookController.class).getAllBooks()).withRel("all-books").withType("GET"));
        bookDTO.add(linkTo(methodOn(BookController.class).deleteBook(id)).withRel("delete-book").withType("DELETE"));
        bookDTO.add(linkTo(methodOn(BookController.class).updateBook(id, bookDTO)).withRel("update-book").withType("PUT"));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookFound");

        return new ResponseEntity<>(bookDTO, headers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable int id, @Valid @RequestBody BookDTO updatedBookDTO) {
              for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(updatedBookDTO.getTitle());
                book.setAuthor(updatedBookDTO.getAuthor());
                book.setPrice(updatedBookDTO.getPrice());
                book.setIsbn(updatedBookDTO.getIsbn());
                HttpHeaders headers = new HttpHeaders();
                headers.add("Custom-Header", "BookUpdated");
                return new ResponseEntity<>(bookMapper.toDTO(book), headers, HttpStatus.OK);
            }
        }
        throw new BookNotFoundException("Book not found with ID: " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id) {
        boolean removed = books.removeIf(book -> book.getId() == id);
        if (removed) {
            HttpHeaders headers = new HttpHeaders();
            headers.add("Custom-Header", "BookDeleted");
            return new ResponseEntity<>("Book with ID " + id + " deleted.", headers, HttpStatus.NO_CONTENT);
        } else {
            throw new BookNotFoundException("Book not found with ID: " + id);
        }
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> bookDTOs = books.stream()
                .map(book -> {
                    BookDTO bookDTO = bookMapper.toDTO(book);
                    bookDTO.add(linkTo(methodOn(BookController.class).getBookById(book.getId())).withSelfRel());
                    bookDTO.add(linkTo(methodOn(BookController.class).deleteBook(book.getId())).withRel("delete-book").withType("DELETE"));
                    bookDTO.add(linkTo(methodOn(BookController.class).deleteBook(book.getId())).withRel("update-book").withType("PUT"));
                    return bookDTO;
                })
                .collect(Collectors.toList());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "AllBooksListed");

        return new ResponseEntity<>(bookDTOs, headers, HttpStatus.OK);
    }

}
