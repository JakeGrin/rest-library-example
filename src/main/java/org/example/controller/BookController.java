package org.example.controller;

import org.example.entity.Book;
import org.example.service.api.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/date")
    public ResponseEntity<List<Book>> getAllBooksByDate(@RequestParam final String search) {
        List<Book> books = bookService.getBooksWithDate(LocalDate.parse(search));
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