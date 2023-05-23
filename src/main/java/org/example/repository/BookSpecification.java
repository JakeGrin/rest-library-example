package org.example.repository;

import org.example.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.expression.spel.ast.Selection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;

public class BookSpecification {

    public static Specification<Book> nameOfBookEqual(String nameOfBook) {
        return (book, cq, cb) -> cb.equal(book.get("nameOfBook"), nameOfBook);
    }

    public static Specification<Book> dateOfPublicationEqual(LocalDate dateOfPublication) {
        return (book, cq, cb) -> {
//            Root<BookAuthor> bookAuthorRoot = cq.from(BookAuthor.class);
//            Join<BookAuthor, Book> bookRoot = bookAuthorRoot.join("bookId");
            Join<Object, Object> join = book.join(BookAuthor_.BOOK_ID);

//
////            Predicate equalityAuthorPredicate = cb.equal(
////                    bookAuthorRoot.get(("authorId")),
////                    author.get("id")
////            );
//
//            Predicate equalityBookPredicate = cb.equal(
//                    bookAuthorRoot.get("bookId"),
//                    book.get("id")
//            );
//
//            Predicate equalityDatePredicate = cb.equal(
//                    book.get("dateOfPublication"),
//                    dateOfPublication);


//            Predicate and = cb.and(  equalityDatePredicate,equalityBookPredicate);
//            return cq.select(bookRoot.get("id")).where(and).getRestriction();        };


            Path<?> dateOfPublication1 = book.get("dateOfPublication");
            return cq.select(book.get("dateOfPublication")).where(cb.equal(dateOfPublication1,dateOfPublication)).getRestriction();
        };
    }

    public static Specification<Book> publishingHouseEqual(String publishingHouse) {
        return (book, cq, cb) -> cb.equal(book.get("publishingHouse"), publishingHouse);
    }

    public static Specification<Book> dayOfBirthEqual(LocalDate dateOfBirthAuthor) {
        return (book, cq, cb) -> {
            Root<BookAuthor> bookAuthorRoot = cq.from(BookAuthor.class);
            Join<BookAuthor, Author> author = bookAuthorRoot.join("authorId");

            Predicate equalityAuthorPredicate = cb.equal(
                    bookAuthorRoot.get(("authorId")),
                    author.get("id")
            );

            Predicate equalityBookPredicate = cb.equal(
                    bookAuthorRoot.get("bookId"),
                    book.get("id")
            );

            Predicate equalityDatePredicate = cb.equal(
                    author.get("dateOfBirthAuthor"),
                    dateOfBirthAuthor);

            Predicate and = cb.and(equalityAuthorPredicate, equalityBookPredicate, equalityDatePredicate);
            return cq.select(book.get("id")).where(and).getRestriction();        };
    }
    public static Specification<Book> genderEqual(String genderAuthor) {
        return (book, cq, cb) -> {
            Root<BookAuthor> bookAuthorRoot = cq.from(BookAuthor.class);
            Join<BookAuthor, Author> author = bookAuthorRoot.join("authorId");



            Predicate equalityAuthorPredicate = cb.equal(
                    bookAuthorRoot.get(("authorId")),
                    author.get("id")
            );

            Predicate equalityBookPredicate = cb.equal(
                    bookAuthorRoot.get("bookId"),
                    book.get("id")
            );

            Predicate equalityDatePredicate = cb.equal(
                    author.get("genderAuthor"),
                    genderAuthor);

            Predicate and = cb.and(equalityAuthorPredicate, equalityBookPredicate, equalityDatePredicate);
            return cq.select(book.get("id")).where(and).getRestriction();
        };
    }
}