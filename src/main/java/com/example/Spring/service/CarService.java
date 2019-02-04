package com.example.Spring.service;

import com.example.Spring.dto.CarDTO;
import com.example.Spring.entity.Car;

import java.util.List;

public interface CarService extends GenericService<Car> {

    CarDTO get(Long id);

    List<CarDTO> getAll();
}
