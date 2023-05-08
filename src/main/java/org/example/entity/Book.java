package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "authors")
public class Book {

//    @ManyToMany(fetch = FetchType.EAGER,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            }, mappedBy = "books")
//    @JsonIgnore
//    private Set<Author> authors = new HashSet<>();

    @OneToMany(mappedBy = "book", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<BookAuthorLink> linkSet;

    @Column(name = "nameOfBook")
    private String nameOfBook;
    @Column(name = "dateOfPublication")
    private LocalDate dateOfPublication;
    @Column(name = "publishingHouse")
    private String publishingHouse;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
}
