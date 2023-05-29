package org.example.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.example.entity.enums.Gender;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Author.class)
public abstract class Author_ {

	public static volatile SingularAttribute<Author, Gender> gender;
	public static volatile SingularAttribute<Author, String> name;
	public static volatile SingularAttribute<Author, LocalDate> dateOfBirth;
	public static volatile SingularAttribute<Author, Integer> id;
	public static volatile SingularAttribute<Author, String> secondName;

	public static final String GENDER = "gender";
	public static final String NAME = "name";
	public static final String DATE_OF_BIRTH = "dateOfBirth";
	public static final String ID = "id";
	public static final String SECOND_NAME = "secondName";

}

