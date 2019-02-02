package com.example.Spring.service;

import com.example.Spring.entity.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenericService <E> {
    void create(E entity);

    void delete(Long id);

    void patch(Long id,E entity);

    void update(Long id,E entity);

    ResponseEntity<E> get(Long id);

    ResponseEntity<List<E>> getAll();
}
