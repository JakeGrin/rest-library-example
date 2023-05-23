package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Book {

    @Column(name = "nameOfBook")
    private String name;
    @Column(name = "dateOfPublication")
    private LocalDate dateOfPublication;
    @Column(name = "publishingHouse")
    private String publishingHouse;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
}
