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
public class BookAuthor {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false, targetEntity = Book.class)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private String bookId;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false, targetEntity = Author.class)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private String authorId;
}