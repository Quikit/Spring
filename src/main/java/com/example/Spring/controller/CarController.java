package com.example.Spring.controller;

import com.example.Spring.dto.CarDTO;
import com.example.Spring.entity.Car;
import com.example.Spring.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {

    @Autowired
    private CarService service;

    @RequestMapping (method = RequestMethod.GET)
    public ResponseEntity<List<CarDTO>> getAll(){
        return new ResponseEntity(service.getAll(), HttpStatus.OK);
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<CarDTO> get(@PathVariable("id") Long id){
        return new ResponseEntity( service.get(id),HttpStatus.OK);
    }

    @RequestMapping (method = RequestMethod.POST)
    public void create(@RequestBody Car car){
        service.create(car);
    }

    @RequestMapping (value = "/{id}",method = RequestMethod.PUT)
    public void update(@PathVariable("id") Long id,@RequestBody Car car){
        car.setId(id);
        service.update(id,car);
    }

    @RequestMapping (value = "/{id}", method =  RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        service.delete(id);
    }

    @RequestMapping (value = "/{id}",method = RequestMethod.PATCH)
    public void patch(@PathVariable("id") Long id,@RequestBody Car car){
        car.setId(id);
        service.patch(id,car);
    }
}
