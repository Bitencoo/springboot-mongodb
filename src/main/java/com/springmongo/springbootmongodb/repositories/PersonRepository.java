package com.springmongo.springbootmongodb.repositories;

import com.springmongo.springbootmongodb.collections.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends MongoRepository<Person, String> {
    List<Person> findByFirstNameStartsWith(String firstName);

    @Query(value = "{ 'age' : { $gt : ?0, $lt : ?1}}")
    List<Person> findPersonByAgeBetween(Integer minAge, Integer maxAge);

}
