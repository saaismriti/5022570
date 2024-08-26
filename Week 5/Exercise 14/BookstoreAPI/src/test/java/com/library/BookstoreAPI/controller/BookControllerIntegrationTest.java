package com.library.BookstoreAPI.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import com.library.BookstoreAPI.repo.BookRepository;
import static org.junit.jupiter.api.Assertions.assertTrue;


import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class BookControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void shouldCreateBook() throws Exception {
        String newBook = "{\"title\": \"New Book\", \"author\": \"Author Name\", \"price\": 29.99}";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(newBook))
                .andExpect(status().isCreated());

        assertTrue(bookRepository.findByTitle("New Book").isPresent());
    }
    
    @Test
    public void shouldReturnBooks() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/books")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
    
}
