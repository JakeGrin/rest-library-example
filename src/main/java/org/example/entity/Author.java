package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

//    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Set<Book> books;
//
//    @ManyToOne(fetch = FetchType.LAZY,optional = false)
//    @JoinColumn(name = "name_of_authors",nullable = false, insertable = false,updatable = false)
//    @JsonIgnore
//    private Book book;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "book_author",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id")}
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
