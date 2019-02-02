package com.example.Spring.repository;

import java.util.List;

import com.example.Spring.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long>{
    List<Person> findByLastName(String lastName);
}
