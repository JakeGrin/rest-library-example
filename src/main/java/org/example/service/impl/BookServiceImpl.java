package org.example.service.impl;

import org.example.entity.Book;
import org.example.repository.AuthorRepository;
import org.example.repository.BookRepository;
import org.example.repository.BookSpecification;
import org.example.service.api.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;



@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBook(int id) {
        return bookRepository.findById(id);
    }

    @Override
    public void updateBook(Book book, int id) {
        Book bookTemp = bookRepository.findById(id).get();
        bookTemp.setNameOfBook(book.getNameOfBook());
        bookTemp.setDateOfPublication(book.getDateOfPublication());
        bookTemp.setPublishingHouse(book.getPublishingHouse());
        bookRepository.save(bookTemp);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooks(final String search) {
        return bookRepository.findAll(
                 BookSpecification.nameOfBookEqual(search)
                .or(BookSpecification.publishingHouseEqual(search))
                .or(BookSpecification.genderEqual(search)));
    }

    public List<Book> getBooksWithDate(final LocalDate search) {
        return bookRepository.findAll(BookSpecification.dateOfPublicationEqual(search)
                .or(BookSpecification.dayOfBirthEqual(search)));
    }

//    @Override
//    public List<Book> getBooksWithNamePublishingHouse(final String publishingHouse) {
////        List<Book> books = new ArrayList<>();
////        List<Book> all = bookRepository.findAll();
////        for (Book book : all) {
////            String nameOfPublHouse = book.getPublishingHouse();
////            if (nameOfPublHouse.equals(nameOfPubl)) {
////                books.add(book);
////            }
////        }
////        return books;
//        return bookRepository.findAll(BookSpecification.publishingHouseEqual(publishingHouse));
//    }

//    @Override
//    public List<Book> getBooksWithGender(String genderAuthor) {
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Book> cq = cb.createQuery(Book.class);
//            Root<Book> book = cq.from(Book.class);
//            Root<BookAuthor> bookAuthorRoot = cq.from(BookAuthor.class);
//            Join<BookAuthor, Author> author = bookAuthorRoot.join("author");
////            Join<BookAuthor, Book> bookRoot = bookAuthorRoot.join("book");
//
//            Predicate equalityAuthorPredicate = cb.equal(
//                    bookAuthorRoot.get("author_id"),
//                    author.get("id")
//            );
//
//            Predicate equalityBookPredicate = cb.equal(
//                    bookAuthorRoot.get("book_id"),
//                    book.get("id")
//            );
//
//            Predicate equalityGenderPredicate = cb.equal(
//                    author.get("genderAuthor"),
//                    genderAuthor);
//
//            cq.where(cb.and(equalityAuthorPredicate,equalityBookPredicate,equalityGenderPredicate));
//            cq.select(book);
//            List<Book> result = em.createQuery(cq).getResultList();
//
//            return result;
//    }

//    @Override
//    public List<Book> getBooksWithDateOfBirthAuthors(LocalDate search) {
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
//        Root<Book> book = cq.from(Book.class);
//        Root<BookAuthor> bookAuthorRoot = cq.from(BookAuthor.class);
//        Join<BookAuthor, Author> author = bookAuthorRoot.join("author");
////            Join<BookAuthor, Book> bookRoot = bookAuthorRoot.join("book");
//
//        Predicate equalityAuthorPredicate = cb.equal(
//                bookAuthorRoot.get("author_id"),
//                author.get("id")
//        );
//
//        Predicate equalityBookPredicate = cb.equal(
//                bookAuthorRoot.get("book_id"),
//                book.get("id")
//        );
//
//        Predicate equalityGenderPredicate = cb.equal(
//                author.get("dateOfBirth"),
//                dateOfBirth);
//
//        cq.where(cb.and(equalityAuthorPredicate,equalityBookPredicate,equalityGenderPredicate));
//        cq.select(book);
//        List<Book> result = em.createQuery(cq).getResultList();
//
////        return result;
//        return bookRepository.findAll(
//                BookSpecification.dayOfBirthEqual(search)
//                        .or(BookSpecification.dateOfPublicationEqual(search)));
//    }


//
//    public List<Book> getBooksWithBookName(final String search) {
//        return bookRepository.findAll(
//                BookSpecification.nameOfBookEqual(search)
//                        .or(BookSpecification.dateOfPublicationEqual(search))) ;
//    }

//    @Override
//    public List<Book> getBooksWithDateOfPublication(String dateOfPubl) {
//        return null;
//    }
//
//    @Override
//    public List<Book> getBooksWithNamePublishingHouse(String nameOfPubl) {
//        return null;
//    }

    @Override
    public List<Book> getBooksWithCombinedMethod() {
        return null;
    }
}
