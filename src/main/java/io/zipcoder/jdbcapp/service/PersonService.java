package io.zipcoder.jdbcapp.service;

import io.zipcoder.jdbcapp.model.Person;
import io.zipcoder.jdbcapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * This is the interface that you will program your PersonServiceImpl to.
 *
 * NOTE: Most of those methods are commented because this is supposed to compile for just the CreatePerson method.
 * You need to uncomment them.
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person createPerson(Person p) {
        return personRepository.save(p);
    }
}
