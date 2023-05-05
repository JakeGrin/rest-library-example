package org.example.controller;

import org.example.entity.Book;
import org.example.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping("/bookName/{bookName}")
    public ResponseEntity<List<Book>> getBooksWithBookName(@PathVariable ("bookName") String bookName){
        return new ResponseEntity<>( bookService.getBooksWithBookName(bookName),HttpStatus.OK);
    }

    @GetMapping("/dateOfPublication/{dateOfPublication}")
    public ResponseEntity<List<Book>> getBooksWithDateOfPublication(
            @PathVariable ("dateOfPublication") String dateOfPublication){
        return new ResponseEntity<>( bookService.getBooksWithDateOfPublication(dateOfPublication),HttpStatus.OK);
    }

    @GetMapping("/nameOfPublishingHouse/{nameOfPublishingHouse}")
    public ResponseEntity<List<Book>> getBooksWithNamePublishingHouse(
            @PathVariable ("nameOfPublishingHouse") String nameOfPublishingHouse){
        return new ResponseEntity<>( bookService.getBooksWithNamePublishingHouse(nameOfPublishingHouse),HttpStatus.OK);
    }

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
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
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
