package org.example.service.api;

import org.example.entity.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {
    void createAuthor(Author author);
    Optional<Author> getAuthor(int id);
    void updateAuthor(Author author, int id);
    void deleteAuthor(int id);
    List<Author> getAllAuthors();
    }
