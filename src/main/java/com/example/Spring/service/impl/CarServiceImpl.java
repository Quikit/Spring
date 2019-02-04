package com.example.Spring.service.impl;

import com.example.Spring.dto.CarDTO;
import com.example.Spring.entity.Car;
import com.example.Spring.repository.CarRepository;
import com.example.Spring.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarServiceImpl implements CarService {


    private final CarRepository repository;

    @Autowired
    ConversionService conversionService;

    @Override
    public void create(Car entity) {
        repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void patch(Long id, Car entity) {
        Car actual = repository.findById(id).get();
        repository.deleteById(id);
        if(entity.getColorCar() != null){
            actual.setColorCar(entity.getColorCar());
        }
        if(entity.getNameCar() != null){
            actual.setNameCar(entity.getNameCar());
        }
        if(entity.getIdPerson() != null ){
            actual.setIdPerson(entity.getIdPerson());
        }
        repository.save(actual);
    }

    @Override
    public void update(Long id, Car entity) {
        repository.deleteById(id);
        repository.save(entity);
    }

    @Override
    public CarDTO get(Long id) {
        Car car = repository.findById(id).get();
        return conversionService.convert(car, CarDTO.class);
    }

    @Override
    public List<CarDTO> getAll() {
        List<Car> all = new ArrayList<>();
        repository.findAll().forEach(all::add);
        List<CarDTO> allDTO = new ArrayList<>();
        for(Car car : all){
            allDTO.add(conversionService.convert(car,CarDTO.class));
        }
        return allDTO;
    }
}
