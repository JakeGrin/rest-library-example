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
//            root.join("author");
//            root.join("book");
            Path<Object> objectPath = root.get(BookAuthor_.ID);
            Path<Object> genderAuthor1 = root.get(BookAuthor_.AUTHOR).get("genderAuthor");
            cq.where(cb.equal(root.get("book_id"),root.get(BookAuthor_.BOOK).get("id")),
                    cb.equal(root.get("author_id"),root.get(BookAuthor_.AUTHOR).get("id")));

//            Join<BookAuthor, Book> bookAuthorBook = bookAuthorRoot.join("book");
//            Join<BookAuthor, Author> bookAuthorAuthor = bookAuthorBook.join("author");
//            return cb.equal(bookAuthorJoin.get("genderAuthor"), genderAuthor);
//              cq.where(cb.and(cb.equal(bookAuthorBook.get("book"))),
//                    cb.equal(bookAuthorAuthor.get("author")));
//              return cb.equal(bookAuthorAuthor.get("genderAuthor"),genderAuthor)
//         return cb.equal(bookAuthorRoot.join(Book_.ID).join(Author_.ID).get("genderAuthor"), genderAuthor);
//            cq.where(cb.equal(root.get(BookAuthor_.AUTHOR).get("genderAuthor"), genderAuthor));
            return cb.equal(genderAuthor1,genderAuthor);




        };
    }
}
