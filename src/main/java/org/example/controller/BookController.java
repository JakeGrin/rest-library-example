package org.example.controller;

import org.example.entity.Book;
import org.example.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

//    @GetMapping("/gender")
//    public ResponseEntity<List<Book>> getBooksWithGender(
//            @RequestParam String search){
//return new ResponseEntity<>(bookService.getBooksWithGender(search),HttpStatus.OK);
//    }

//    @GetMapping("/date")
//    public ResponseEntity<List<Book>> getBooksWithDateOfBirthAuthors(
//            @RequestParam  String search){
//        List<Book> books = bookService.getBooksWithDateOfBirthAuthors(LocalDate.parse(search));
//        return new ResponseEntity<>( books,HttpStatus.OK);
//    }
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam String search) {
        List<Book> books = bookService.getAllBooks(search);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }



    @GetMapping("/date")
    public ResponseEntity<List<Book>> getAllBooksByDate(@RequestParam String search) {
        List<Book> books = bookService.getBooksWithDate(LocalDate.parse(search));
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") int id) {
        Optional<Book> book = bookService.getBook(id);
        return new ResponseEntity<>(book.get(), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Book> deleteBook(@PathVariable("id") int id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        bookService.createBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Book> updateBook(@RequestParam("id") int id, @RequestBody Book book) {
        bookService.updateBook(book, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
