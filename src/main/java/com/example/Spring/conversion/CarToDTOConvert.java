package com.example.Spring.conversion;

import com.example.Spring.dto.CarDTO;
import com.example.Spring.entity.Car;
import org.springframework.core.convert.converter.Converter;

public class CarToDTOConvert implements Converter<Car, CarDTO> {

    @Override
    public CarDTO convert(Car car) {
        String nameCar = car.getNameCar();
        String colorCar = car.getColorCar();
        long idPerson = Long.parseLong(car.getIdPerson());
        return new CarDTO(nameCar,colorCar,idPerson);
    }
}
