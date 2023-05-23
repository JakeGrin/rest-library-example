package org.example.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(BookAuthor.class)
public abstract class BookAuthor_ {

	public static volatile SingularAttribute<BookAuthor, Integer> id;
	public static volatile SingularAttribute<BookAuthor, Author> authorId;
	public static volatile SingularAttribute<BookAuthor, Book> bookId;

	public static final String ID = "id";
	public static final String AUTHOR_ID = "authorId";
	public static final String BOOK_ID = "bookId";

}

