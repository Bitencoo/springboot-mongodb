package com.springmongo.springbootmongodb.controllers;

import com.springmongo.springbootmongodb.collections.Person;
import com.springmongo.springbootmongodb.services.PersonService;
import org.apache.coyote.Response;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping
    public String savePerson(@RequestBody Person person) {
        return personService.save(person);
    }
    @GetMapping
    public List<Person> getAllPeople() {
        return personService.getAllPeople();
    }

    @GetMapping("{firstName}")
    public List<Person> getPeopleStartWith(@PathVariable("firstName") String firstName) {
        return personService.getPeopleStartWith(firstName);
    }

    @GetMapping("{/age}")
    public List<Person> getPersonByAgeBetween(@RequestParam Integer minAge,
                                            @RequestParam Integer maxAge) {
        return personService.getPersonByAgeBetween(minAge, maxAge);
    }

    @DeleteMapping("{/id}")
    public void deletePerson(@PathVariable("id") String personId) {
        personService.deletePerson(personId);
    }

    @GetMapping("/search")
    public Page<Person> searchPerson(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,
            @RequestParam(required = false) String city,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "5") Integer size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return personService.search(name, minAge, maxAge, city, pageable);
    }
    @GetMapping("/oldestPerson")
    public List<Document> getOldestPerson() {
        return personService.getOldestPersonByCity();
    }

    @GetMapping("/citiesPopulation")
    public List<Document> getPoupulationByCity() {
        return personService.getPopulationByCity();
    }
}
