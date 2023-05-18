package org.example.repository;

import org.example.entity.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.expression.spel.ast.Selection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.util.List;

public class BookSpecification {
    static EntityManager em;

    public static Specification<Book> nameOfBookEqual(String nameOfBook) {
        return (book, cq, cb) -> cb.equal(book.get("nameOfBook"), nameOfBook);
    }

    public static Specification<Book> dateOfPublicationEqual(LocalDate dateOfPublication) {
        return (book, cq, cb) -> cb.equal(book.get("dateOfPublication"), dateOfPublication);
    }

    public static Specification<Book> publishingHouseEqual(String publishingHouse) {
        return (book, cq, cb) -> cb.equal(book.get("publishingHouse"), publishingHouse);
    }
}
//
//    public static Specification<Book> genderEqual(String genderAuthor) {
//
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Book> cq = cb.createQuery(Book.class);
//        Root<Book> book = cq.from(Book.class);
//        Root<BookAuthor> bookAuthorRoot = cq.from(BookAuthor.class);
//            Join<BookAuthor, Author> author = bookAuthorRoot.join("author");
//            Join<BookAuthor, Book> bookRoot = bookAuthorRoot.join("book");
//
//                Predicate equalityAuthorPredicate = cb.equal(
//                        bookAuthorRoot.get("author_id"),
//                        author.get("id")
//                );
//
//                Predicate equalityBookPredicate = cb.equal(
//                        bookAuthorRoot.get("book_id"),
//                        book.get("id")
//                );
//
//        Predicate equalityGenderPredicate = cb.equal(
//                author.get("genderAuthor"),
//                genderAuthor);
//
//            cq.where(cb.and(equalityAuthorPredicate,equalityBookPredicate,equalityGenderPredicate));
//            cb.createQuery();
//            List<Book> result = em.createQuery(cq).getResultList();
//
//            return result;



//
//        };
//    }
//}
