package com.springmongo.springbootmongodb.services;

import com.springmongo.springbootmongodb.collections.Person;
import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonService {
    String save(Person person);
    List<Person> getAllPeople();
    List<Person> getPeopleStartWith(String firstName);
    List<Person> getPersonByAgeBetween(Integer minAge, Integer maxAge);
    void deletePerson(String personId);

    Page<Person> search(String name, Integer minAge, Integer maxAge, String city, Pageable pageable);

    List<Document> getOldestPersonByCity();
    List<Document> getPopulationByCity();
}
