package com.example.Spring.dto;
import lombok.Data;

@Data
public class CarDTO {
    private long id;
    private String nameCar;
    private String colorCar;
    private String idPerson;

    protected CarDTO() {
    }

    public CarDTO(String nameCar, String colorCar, long idPerson) {
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
