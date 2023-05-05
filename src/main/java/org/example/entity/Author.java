package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "books")
public class Author {


    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "book_author",
            joinColumns = {@JoinColumn(name = "book_id")},
            inverseJoinColumns = {@JoinColumn(name = "author_id")}
    )
    Set<Book> books = new HashSet<>();

    @Column(name = "nameAuthor")
    private String nameAuthor;
    @Column(name = "secondNameAuthor")
    private String secondNameAuthor;
    @Column(name = "dateOfBirthAuthor")
    private LocalDate dateOfBirthAuthor;
    @Column(name = "genderAuthor")
    private String genderAuthor;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
}
