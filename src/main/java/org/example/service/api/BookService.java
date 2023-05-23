package org.example.service.api;

import org.example.entity.Book;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookService {
    void createBook(Book book);
    Optional<Book> getBook(int id);
    void updateBook(Book book,int id);
    void deleteBook(int id);
    List<Book> getAllBooks(String search);

    List<Book> getBooksWithDate(LocalDate search);

//    List<Book> getBooksWithGender(String gender);
//    List<Book> getBooksWithDateOfBirthAuthors(LocalDate dateOfBirth);
    List<Book> getBooksWithCombinedMethod();
}
