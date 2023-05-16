package org.example.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, String> nameOfBook;
	public static volatile SingularAttribute<Book, String> publishingHouse;
	public static volatile SingularAttribute<Book, Integer> id;
	public static volatile SingularAttribute<Book, LocalDate> dateOfPublication;

	public static final String NAME_OF_BOOK = "nameOfBook";
	public static final String PUBLISHING_HOUSE = "publishingHouse";
	public static final String ID = "id";
	public static final String DATE_OF_PUBLICATION = "dateOfPublication";

}

