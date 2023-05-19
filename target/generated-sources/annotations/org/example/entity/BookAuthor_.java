package org.example.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BookAuthor.class)
public abstract class BookAuthor_ {

	public static volatile SingularAttribute<BookAuthor, Author> author;
	public static volatile SingularAttribute<BookAuthor, Book> book;
	public static volatile SingularAttribute<BookAuthor, Integer> id;

	public static final String AUTHOR = "author";
	public static final String BOOK = "book";
	public static final String ID = "id";

}

