package io.zipcoder.jdbcapp.controller;

import io.zipcoder.jdbcapp.model.Person;
import io.zipcoder.jdbcapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Here is where all of the Controller logic goes for the person endpoints.
 */
@Controller
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/people", method = RequestMethod.POST)
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person createdPerson = personService.createPerson(person);
        return new ResponseEntity<Person>(createdPerson, HttpStatus.CREATED);
    }
}
