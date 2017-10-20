package io.zipcoder.jdbcapp.repository;

import io.zipcoder.jdbcapp.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * This is the interface that you will program your PersonRepositoryImpl to.
 *
 * NOTE: Most of those methods are commented because this is supposed to compile for just the CreatePerson method.
 * You need to uncomment them.
 */
public interface PersonRepository extends JpaRepository<Person, Integer> {

}
