package org.example.repository;

import org.example.entity.Author;
import org.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;

import java.util.List;

public interface BookAuthorRepository extends JpaRepository<Book, Author> {


    @Query(value = " book b join " +
            " book_author ba on b.id = ba.book_id " +
            " join author a on ba.author_id = a.id "
            , nativeQuery = true)
    static void joinTables() {

    }
}
