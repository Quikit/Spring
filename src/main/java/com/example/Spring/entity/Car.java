package com.example.Spring.entity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nameCar;
    private String colorCar;
    private String idPerson;

    protected Car() {
    }

    public Car(String nameCar, String colorCar, long idPerson) {
        this.nameCar = nameCar;
        this.colorCar = colorCar;
        this.idPerson = Long.toString(idPerson);
    }

    @Override
    public String toString() {
        return String.format(
                "Car[id=%d, idPerson='%s', NameCar='%s', ColorCar='%s']",
                id, idPerson, nameCar, colorCar);
    }
}