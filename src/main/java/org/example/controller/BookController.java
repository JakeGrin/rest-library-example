package org.example.controller;

import org.example.entity.Book;
import org.example.service.api.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam final String search) {
        List<Book> books = bookService.getAllBooks(search);
        List<Book> collect = books.stream().distinct().collect(Collectors.toList());
        return new ResponseEntity<>(collect, HttpStatus.OK);
    }

    @GetMapping("/dateBirth")
    public ResponseEntity<List<Book>> getAllBooksByDateOfBirth(@RequestParam final String[] search) {
        List<Book> result = new ArrayList<>();
        for (String s:search) {
            List<Book> books = bookService.getBooksWithDateOfBirth(LocalDate.parse(s));
            result.addAll(books);
        }
        List<Book> collect = result.stream().distinct().collect(Collectors.toList());
        return new ResponseEntity<>(collect, HttpStatus.OK);
    }

    @GetMapping("/datePubl")
    public ResponseEntity<List<Book>> getAllBooksByDateOfPublication(@RequestParam final String search) {
        List<Book> books = bookService.getBooksWithDateOfPubl(LocalDate.parse(search));
//        List<Book> collect = books.stream().distinct().collect(Collectors.toList());
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") final int id) {
        Optional<Book> book = bookService.getBook(id);
        return new ResponseEntity<>(book.get(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Book> deleteBook(@PathVariable("id") final int id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody final Book book) {
        bookService.createBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestParam("id") int id, @RequestBody final Book book) {
        bookService.updateBook(book, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}