package org.example.service.impl;

import org.example.entity.Book;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
import org.example.repository.BookSpecification;
import org.example.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;



@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBook(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void updateBook(Book book, int id) {
        Book bookTemp = bookRepository.findById(id).get();
        bookTemp.setName(book.getName());
        bookTemp.setDateOfPublication(book.getDateOfPublication());
        bookTemp.setPublishingHouse(book.getPublishingHouse());
        bookRepository.save(bookTemp);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooks(final String search) {
        return bookRepository.findAll(
                 BookSpecification.nameOfBookEqual(search)
                .or(BookSpecification.publishingHouseEqual(search))
                .or(BookSpecification.genderEqual(search)));
    }

    public List<Book> getBooksWithDateOfPubl(final LocalDate search) {
        return bookRepository.findAll(BookSpecification.dateOfPublicationEqual(search));
    }

    public List<Book> getBooksWithDateOfBirth(final LocalDate search) {
        return bookRepository.findAll(BookSpecification.dayOfBirthEqual(search));
    }
    @Override
    public List<Book> getBooksWithCombinedMethod() {
        return null;
    }
}
