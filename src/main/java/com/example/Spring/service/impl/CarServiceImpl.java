package com.example.Spring.service.impl;

import com.example.Spring.entity.Car;
import com.example.Spring.repository.CarRepository;
import com.example.Spring.service.CarService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository repository;

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
    public ResponseEntity<Car> get(Long id) {
        return ResponseEntity.of(repository.findById(id));
    }

    @Override
    public ResponseEntity<List<Car>> getAll() {
        List<Car> all = null;
        repository.findAll().forEach(all::add);

        List<JSONObject> entities = new ArrayList<JSONObject>();
        for (Car car : all) {
            JSONObject entity = new JSONObject();
            try {
                entity.put("id", car.getId());
                entity.put("carColor", car.getColorCar());
                entity.put("carName", car.getNameCar());
                entity.put("idPerson", car.getIdPerson());
                entities.add(entity);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return new ResponseEntity(entities, HttpStatus.OK);
    }
}
