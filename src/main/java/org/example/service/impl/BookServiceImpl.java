package org.example.service.impl;

import org.example.entity.Book;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
import org.example.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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
        bookTemp.setNameOfBook(book.getNameOfBook());
        bookTemp.setDateOfPublication(book.getDateOfPublication());
        bookTemp.setPublishingHouse(book.getPublishingHouse());
        bookRepository.save(bookTemp);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    @Override
    public List<Book> getBooksWithBookName(String bookName) {
        List<Book> books = new ArrayList<>();
        List<Book> all = bookRepository.findAll();
        for (Book book : all) {
            String nameOfBook = book.getNameOfBook();
            boolean equals = nameOfBook.equals(bookName);
            if (equals) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> getBooksWithDateOfPublication(String dateOfPubl) {
        LocalDate date = LocalDate.parse(dateOfPubl);

        List<Book> books = new ArrayList<>();
        List<Book> all = bookRepository.findAll();
        for (Book book : all) {
            LocalDate dateOfBook = book.getDateOfPublication();
            if (dateOfBook.equals(date)) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> getBooksWithNamePublishingHouse(String nameOfPubl) {
        List<Book> books = new ArrayList<>();
        List<Book> all = bookRepository.findAll();
        for (Book book : all) {
            String nameOfPublHouse = book.getPublishingHouse();
            if (nameOfPublHouse.equals(nameOfPubl)) {
                books.add(book);
            }
        }
        return books;
    }

    @Override
    public List<Book> getBooksWithGender(String gender) {
        List<Book> all = bookRepository.findAll();
        return bookRepository.findAllByAuthorGender(gender);
    }

    @Override
    public List<Book> getBooksWithDateOfBirthAuthors(LocalDate dateOfBirth) {
        List<Book> books = new ArrayList<>();
        List<Book> all = bookRepository.findAll();
        return books;
    }

    @Override
    public List<Book> getBooksWithNamesOfAuthors() {
        return null;
    }

    @Override
    public List<Book> getBooksWithCombinedMethod() {
        return null;
    }
}
