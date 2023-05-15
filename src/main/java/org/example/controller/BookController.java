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

//    @GetMapping
//    public ResponseEntity<List<Book>> getBooksWithBookName(@RequestParam String search){
//        List<Book> books = bookService.getBooksWithBookName(search);
//        return new ResponseEntity<>( books,HttpStatus.OK);
//    }

//    @GetMapping
//    public ResponseEntity<List<Book>> getBooksWithDateOfPublication(
//            @RequestParam String search){
////LocalDate date = LocalDate.parse(search);
//        List<Book> booksWithDateOfPublication = bookService.getBooksWithDateOfPublication(search);
//        return new ResponseEntity<>(booksWithDateOfPublication,HttpStatus.OK);
//    }

//    @GetMapping
//    public ResponseEntity<List<Book>> getBooksWithNamePublishingHouse(
//            @RequestParam String search){
//        return new ResponseEntity<>( bookService.getBooksWithNamePublishingHouse(search),HttpStatus.OK);
//    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<Book>> getBooksWithGender(
            @PathVariable ("gender") String gender){
        return new ResponseEntity<>( bookService.getBooksWithGender(gender),HttpStatus.OK);
    }

    @GetMapping("/dateOfBirthAuthors/{dayOfBirthAuthors}")
    public ResponseEntity<List<Book>> getBooksWithDateOfBirthAuthors(
            @PathVariable ("dayOfBirthAuthors") LocalDate dayOfBirthAuthors){
        return new ResponseEntity<>( bookService.getBooksWithDateOfBirthAuthors(dayOfBirthAuthors),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks(@RequestParam String search) {
        List<Book> books = bookService.getAllBooks(search);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }



//    @GetMapping
//    public ResponseEntity<List<Book>> getAllBooks(@RequestParam LocalDate search) {
//        List<Book> books = bookService.getAllBooks(search);
//        return new ResponseEntity<>(books, HttpStatus.OK);
//    }

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
