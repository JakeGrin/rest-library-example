package org.example.entity;


import lombok.*;

import javax.persistence.*;
@Entity
@Table(name = "book_author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = {"book", "author"})
public class BookAuthor {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE},optional = false, targetEntity = Book.class)
    @JoinColumn(name = "book_id",referencedColumnName="id")
    private Book book;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},optional = false, targetEntity = Author.class)
    @JoinColumn(name = "author_id",referencedColumnName="id")
    private Author author;

    @Column(name="book_id",insertable = false,updatable = false)
    String book_id;

    @Column(name="author_id",insertable = false,updatable = false)
    String author_id;
}
