package org.example.repository;

import org.example.entity.*;
import org.example.entity.enums.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.expression.spel.ast.Selection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import javax.persistence.metamodel.SingularAttribute;
import java.time.LocalDate;
import java.util.List;

public class BookSpecification {

    public static Specification<Book> nameOfBookEqual(String name) {
        return (book, cq, cb) -> cb.equal(book.get("name"), name);
    }

    public static Specification<Book> dateOfPublicationEqual(LocalDate dateOfPublication) {
        return (book, cq, cb) -> {

            Predicate equalityDatePredicate = cb.equal(
                    book.get("dateOfPublication"),
                    dateOfPublication);

            Predicate and = cb.and( equalityDatePredicate);
            Predicate restriction = cq.select(book.get(Book_.ID)).where(and).getRestriction();

            return restriction;
        };
    }

    public static Specification<Book> publishingHouseEqual(String publishingHouse) {
        return (book, cq, cb) -> cb.equal(book.get("publishingHouse"), publishingHouse);
    }

    public static Specification<Book> dayOfBirthEqual(LocalDate dateOfBirth) {
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
                    author.get("dateOfBirth"),
                    dateOfBirth);

            Predicate and = cb.and(equalityAuthorPredicate, equalityBookPredicate, equalityDatePredicate);
            return cq.select(book.get("id")).where(and).getRestriction();        };
    }
    public static Specification<Book> genderEqual(String gender) {
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

            Gender byValue = Gender.findByValue(gender);
            Predicate equalityDatePredicate = cb.equal(
                    author.get("gender"),
                    byValue);

            Predicate and = cb.and(equalityAuthorPredicate, equalityBookPredicate, equalityDatePredicate);
            return cq.select(book.get("id")).where(and).getRestriction();
        };
    }
}