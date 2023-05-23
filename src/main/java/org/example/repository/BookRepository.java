package org.example.repository;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.example.entity.Author;
import org.example.entity.Book;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Projections;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> , JpaSpecificationExecutor<Book> {


    @Query(value = "select b.* from book b join " +
            " book_author ba on b.id = ba.book_id " +
            " join author a on ba.author_id = a.id " +
            " where a.gender_author = :gender", nativeQuery = true)
    List<Book> findAllByAuthorGender(String gender);
}
