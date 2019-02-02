package com.example.Spring.repository;

import java.util.List;

import com.example.Spring.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findByNameCar(String nameCar);
}
