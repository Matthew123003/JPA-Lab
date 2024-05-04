package io.zipcoder.jdbcapp.controller;

import io.zipcoder.jdbcapp.model.Person;
import io.zipcoder.jdbcapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "/people/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Person> updatePerson(@PathVariable Integer id, @RequestBody Person updatedPerson) {
        Person updatedPersonResult = personService.updatePerson(id, updatedPerson);
        return ResponseEntity.ok(updatedPersonResult);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> getPersonById(@PathVariable Integer id) {
        Person person = personService.getPersonById(id);
        return ResponseEntity.ok(person);
    }

    @RequestMapping(value = "/people/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/people", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getAllPeople() {
        List<Person> people = personService.getAllPeople();
        return ResponseEntity.ok(people);
    }

    @RequestMapping(value = "/people/reverselookup/{mobileNumber}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findPeopleByMobileNumber(@PathVariable String mobileNumber) {
        List<Person> people = personService.findPeopleByMobileNumber(mobileNumber);
        return ResponseEntity.ok(people);
    }

    @RequestMapping(value = "/people/surname/{lastName}", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> findPeopleByLastName(@PathVariable String lastName) {
        List<Person> people = personService.findPeopleByLastName(lastName);
        return ResponseEntity.ok(people);
    }

    @RequestMapping(value = "/people/surname/stats", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Integer>> getSurnameStatistics() {
        Map<String, Integer> surnameStats = personService.getSurnameStatistics();
        return ResponseEntity.ok(surnameStats);
    }

    @RequestMapping(value = "/people/firstname/stats", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Integer>> getFirstnameStatistics() {
        Map<String, Integer> firstnameStats = personService.getFirstnameStatistics();
        return ResponseEntity.ok(firstnameStats);
    }

    @RequestMapping(value = "/people/birthday/stats", method = RequestMethod.GET)
    public ResponseEntity<Map<Date, Integer>> getBirthdayStatistics() {
        Map<Date, Integer> birthdayStats = personService.getBirthdayStatistics();
        return ResponseEntity.ok(birthdayStats);
    }

}
