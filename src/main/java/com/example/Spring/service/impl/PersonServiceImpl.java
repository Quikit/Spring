package com.example.Spring.service.impl;

import com.example.Spring.entity.Person;
import com.example.Spring.repository.PersonRepository;
import com.example.Spring.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

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
    public Person get(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Person> getAll() {
       /* List<Person> all = null;
        repository.findAll().forEach(all::add);
        Optional<Person> min = all;
       return ResponseEntity.of(all);*/
        List<Person> all = new ArrayList<>();
        repository.findAll().forEach(all::add);

        return all;
    }
}
