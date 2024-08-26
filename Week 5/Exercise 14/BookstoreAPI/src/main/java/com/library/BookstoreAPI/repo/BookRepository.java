package com.library.BookstoreAPI.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.library.BookstoreAPI.model.Book;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    // Custom query method to find a book by its title
    Optional<Book> findByTitle(String title);
}
