package org.example.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Author.class)
public abstract class Author_ {

	public static volatile SingularAttribute<Author, LocalDate> dateOfBirthAuthor;
	public static volatile SingularAttribute<Author, String> genderAuthor;
	public static volatile SingularAttribute<Author, String> nameAuthor;
	public static volatile SingularAttribute<Author, String> secondNameAuthor;
	public static volatile SingularAttribute<Author, Integer> id;

	public static final String DATE_OF_BIRTH_AUTHOR = "dateOfBirthAuthor";
	public static final String GENDER_AUTHOR = "genderAuthor";
	public static final String NAME_AUTHOR = "nameAuthor";
	public static final String SECOND_NAME_AUTHOR = "secondNameAuthor";
	public static final String ID = "id";

}

