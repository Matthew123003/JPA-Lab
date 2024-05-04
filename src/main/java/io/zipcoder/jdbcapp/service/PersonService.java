package io.zipcoder.jdbcapp.service;

import io.zipcoder.jdbcapp.model.Person;
import io.zipcoder.jdbcapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
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

    public Person updatePerson(Integer id, Person updatedPerson) {
        Person existingPerson = personRepository.findOne(id);
        existingPerson.setFirstName(updatedPerson.getFirstName());
        existingPerson.setLastName(updatedPerson.getLastName());
        existingPerson.setMobile(updatedPerson.getMobile());
        existingPerson.setBirthday(updatedPerson.getBirthday());
        return personRepository.save(existingPerson);
    }

    public Person getPersonById(Integer id) {
        return personRepository.findOne(id);
    }

    public void deletePerson(Integer id) {
        personRepository.delete(id);
    }

    public List<Person> getAllPeople() {
        return personRepository.findAll();
    }

    public List<Person> findPeopleByMobileNumber(String mobileNumber) {
        return personRepository.findByMobileNumber(mobileNumber);
    }

    public List<Person> findPeopleByLastName(String lastName) {
        return personRepository.findByLastName(lastName);
    }

    public Map<String, Integer> getSurnameStatistics() {
        List<Person> people = personRepository.findAll();
        Map<String, Integer> surnameCounts = new HashMap<>();
        for (Person person : people) {
            String lastName = person.getLastName();
            surnameCounts.put(lastName, surnameCounts.getOrDefault(lastName, 0) + 1);
        }
        return surnameCounts;
    }

    public Map<String, Integer> getFirstnameStatistics() {
        List<Person> people = personRepository.findAll();
        Map<String, Integer> firstnameCounts = new HashMap<>();
        for (Person person : people) {
            String firstName = person.getFirstName();
            firstnameCounts.put(firstName, firstnameCounts.getOrDefault(firstName, 0) + 1);
        }
        return firstnameCounts;
    }

    public Map<Date, Integer> getBirthdayStatistics() {
        List<Person> people = personRepository.findAll();
        Map<Date, Integer> birthdayCounts = new HashMap<>();
        for (Person person : people) {
            Date birthday = person.getBirthday();
            birthdayCounts.put(birthday, birthdayCounts.getOrDefault(birthday, 0) + 1);
        }
        return birthdayCounts;
    }

    public void removePeople(List<Integer> personIds) {
        personRepository.deleteAllByIdIn(personIds);
    }

    public List<Person> findPeopleByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }

    public List<Person> findPeopleByBirthday(Date birthday) {
        return personRepository.findByBirthday(birthday);
    }

}
