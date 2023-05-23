package org.example.repository;

import org.example.entity.Author;
import org.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAuthorRepository extends JpaRepository<Book, Author> {
}

