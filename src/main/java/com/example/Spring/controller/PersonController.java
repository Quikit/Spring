package com.example.Spring.controller;

import com.example.Spring.entity.Person;
import com.example.Spring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    private PersonService service;

    @RequestMapping (method = RequestMethod.GET)
    public ResponseEntity<List<Person>> getAll(){
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Person> get(@PathVariable("id") Long id){
        return new ResponseEntity( service.get(id),HttpStatus.OK);
    }

    @RequestMapping (method = RequestMethod.POST)
    public void create(@RequestBody Person person){
        service.create(person);
    }

    @RequestMapping (value = "/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable("id") Long id,@RequestBody Person person){
        person.setId(id);
        service.update(id,person);
    }

    @RequestMapping (value = "/{id}", method =  RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    @RequestMapping (value = "/{id}",method = RequestMethod.PATCH)
    public void patch(@PathVariable("id") Long id,@RequestBody Person person){
        person.setId(id);
        service.patch(id,person);
    }
}
