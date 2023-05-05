package org.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "authors")
public class Book{

//    @ManyToOne(fetch = FetchType.LAZY,optional = false)
//    @JoinColumn(name = "id",nullable = false, insertable = false,updatable = false)
//    @JsonIgnore
//    private Author author;
//
//    @OneToMany(mappedBy="book", fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//    @JsonIgnore
//    private Set<Author> authors;

    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "books")
    @JsonIgnore
    private Set<Author> authors = new HashSet<>();

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
