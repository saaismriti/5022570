package com.library.BookstoreAPI.controller;
import com.library.BookstoreAPI.exception.BadRequestException;
import com.library.BookstoreAPI.exception.BookNotFoundException;
import com.library.BookstoreAPI.model.Book;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;


@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title, @RequestParam(required = false) String author) {
        return books.stream()
                .filter(book -> (title == null || book.getTitle().toLowerCase().contains(title.toLowerCase())) &&
                                (author == null || book.getAuthor().toLowerCase().contains(author.toLowerCase())))
                .collect(Collectors.toList());
    }


    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        if (book.getId() <= 0) {
            throw new BadRequestException("Invalid book ID");
        }
        books.add(book);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookCreated");
        return new ResponseEntity<>(book, headers, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .map(book -> {
                    HttpHeaders headers = new HttpHeaders();
                    headers.add("Custom-Header", "BookFound");
                    return new ResponseEntity<>(book, headers, HttpStatus.OK);
                })
                .orElseThrow(() -> new BookNotFoundException("Book not found with ID: " + id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        for (Book book : books) {
            if (book.getId() == id) {
                book.setTitle(updatedBook.getTitle());
                book.setAuthor(updatedBook.getAuthor());
                book.setPrice(updatedBook.getPrice());
                book.setIsbn(updatedBook.getIsbn());
                HttpHeaders headers = new HttpHeaders();
                headers.add("Custom-Header", "BookUpdated");
                return new ResponseEntity<>(book, headers, HttpStatus.OK);
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
    public ResponseEntity<List<Book>> getAllBooks() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "AllBooksListed");
        return new ResponseEntity<>(books, headers, HttpStatus.OK);
    }
}
