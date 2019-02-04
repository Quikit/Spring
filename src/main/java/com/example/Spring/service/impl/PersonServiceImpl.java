package com.example.Spring.service.impl;

import com.example.Spring.dto.PersonDTO;
import com.example.Spring.entity.Person;
import com.example.Spring.repository.PersonRepository;
import com.example.Spring.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Autowired
    ConversionService conversionService;

    @Override
    public void create(Person entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void patch(Long id, Person entity) {
        Person actual = repository.findById(id).get();
        repository.deleteById(id);
        if(entity.getFirstName() != null){
            actual.setFirstName(entity.getFirstName());
        }
        if(entity.getLastName() != null){
            actual.setLastName(entity.getLastName());
        }
        repository.save(actual);
    }

    @Override
    public void update(Long id, Person entity) {
        repository.deleteById(id);
        repository.save(entity);
    }

    @Override
    public PersonDTO get(Long id) {
        Person person = repository.findById(id).get();
        return conversionService.convert(person,PersonDTO.class);
    }

    @Override
    public List<PersonDTO> getAll() {
        List<Person> all = new ArrayList<>();
        repository.findAll().forEach(all::add);
        List<PersonDTO> allDTO = new ArrayList<>();
        for(Person person : all){
            allDTO.add(conversionService.convert(person,PersonDTO.class));
        }
        return allDTO;
    }
}
