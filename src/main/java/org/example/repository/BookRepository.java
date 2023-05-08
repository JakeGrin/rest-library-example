package org.example.repository;

import org.example.entity.Book;
import org.hibernate.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    Session session = HibernateUtil.getHibernateSession();
    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaQuery<Item> cr = cb.createQuery(Item.class);
    Root<Item> root = cr.from(Item.class);
cr.select(root);

    Query<Item> query = session.createQuery(cr);
    List<Item> results = query.getResultList();


    @Query(value = "select b.* from book b join " +
            " book_author ba on b.id = ba.book_id " +
            " join author a on ba.author_id = a.id " +
            " where a.gender_author = :gender", nativeQuery = true)
    List<Book> findAllByAuthorGender(String gender);
}
