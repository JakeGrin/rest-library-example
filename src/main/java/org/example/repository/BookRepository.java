package org.example.repository;

import org.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    @Query(value = " select b.* from book b join " +
            " book_author ba on b.id = ba.book_id " +
            " join " +
            " author a on ba.author_id = a.id " +
            " where a.gender_author = :gender",nativeQuery = true)
    List<Book> findAllByAuthorGender(String gender);
}
