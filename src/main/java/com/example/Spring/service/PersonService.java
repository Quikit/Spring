package com.example.Spring.service;

import com.example.Spring.dto.PersonDTO;
import com.example.Spring.entity.Person;

import java.util.List;

public interface PersonService extends GenericService<Person>{

    PersonDTO get(Long id);

    List<PersonDTO> getAll();
}
