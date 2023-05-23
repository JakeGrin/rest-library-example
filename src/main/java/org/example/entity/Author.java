package org.example.entity;

import lombok.*;
import org.example.entity.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "author")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(exclude = "books")
public class Author {

    @Column(name = "nameAuthor")
    private String name;
    @Column(name = "secondNameAuthor")
    private String secondName;
    @Column(name = "dateOfBirthAuthor")
    private LocalDate dateOfBirth;
    @Column(name = "genderAuthor")
    private Gender gender;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
}
