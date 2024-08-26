package com.library.BookstoreAPI.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.library.BookstoreAPI.dto.BookDTO;
import com.library.BookstoreAPI.mapper.BookMapper;
import com.library.BookstoreAPI.model.Book;

import io.micrometer.core.instrument.MeterRegistry;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookMapper bookMapper;

    @MockBean
    private MeterRegistry meterRegistry;

    @BeforeEach
    void setUp() {
        // Example data setup
        BookDTO bookDTO = new BookDTO(1, "Test Title", "Test Author", 19.99, "12345678901");
        when(bookMapper.toDTO(any(Book.class))).thenReturn(bookDTO);
        when(bookMapper.toEntity(any(BookDTO.class))).thenReturn(new Book(1, "Test Title", "Test Author", 19.99, "12345678901"));
    }
    
    @Test
    public void testCreateBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1, \"title\": \"Test Title\", \"author\": \"Test Author\", \"price\": 19.99, \"isbn\": \"12345678901\" }"));
    }
    
    @Test
    public void testGetAllBooks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/books")
                .accept(MediaType.APPLICATION_JSON));
                
    }

    @Test
    public void testGetBookById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/books/1")
                .accept(MediaType.APPLICATION_JSON));
    }

   

    @Test
    public void testUpdateBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.put("/books/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1, \"title\": \"Updated Title\", \"author\": \"Updated Author\", \"price\": 25.00, \"isbn\": \"98765432177\" }"));
    }

    @Test
    public void testDeleteBook() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/books/1"));
    }
}
