package org.example.repository;

import org.example.entity.*;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.time.LocalDate;

public class BookSpecification {



    public static Specification<Book> nameOfBookEqual(String nameOfBook) {
        return (book, cq, cb) -> cb.equal(book.get("nameOfBook"), nameOfBook);
    }

    public static Specification<Book> dateOfPublicationEqual(LocalDate dateOfPublication) {
        return (book, cq, cb) -> cb.equal(book.get("dateOfPublication"),   dateOfPublication );
    }
    public static Specification<Book> publishingHouseEqual(String publishingHouse) {
        return (book, cq, cb) -> cb.equal(book.get("publishingHouse"),  publishingHouse );
    }

    public static Specification<Book> genderEqual(String genderAuthor) {
        return (book, cq, cb) -> {
            Root<BookAuthor> root = cq.from(BookAuthor.class);
//            Join<BookAuthor, Book> bookAuthorBook = bookAuthorRoot.join("book");
//            Join<BookAuthor, Author> bookAuthorAuthor = bookAuthorBook.join("author");
//            return cb.equal(bookAuthorJoin.get("genderAuthor"), genderAuthor);
//              cq.where(cb.and(cb.equal(bookAuthorBook.get("book"))),
//                    cb.equal(bookAuthorAuthor.get("author")));
//              return cb.equal(bookAuthorAuthor.get("genderAuthor"),genderAuthor)
//         return cb.equal(bookAuthorRoot.join(Book_.ID).join(Author_.ID).get("genderAuthor"), genderAuthor);
//            Path<Object> genderAuthor1 = root.get(BookAuthor_.AUTHOR).get("genderAuthor");
            return cb.equal(book.get(BookAuthor_.AUTHOR).get("genderAuthor"),genderAuthor);




        };
    }
}
