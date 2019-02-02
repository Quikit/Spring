package com.example.Spring;

import com.example.Spring.repository.PersonRepository;
import com.example.Spring.entity.Car;
import com.example.Spring.entity.Person;
import com.example.Spring.repository.CarRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SpringProjectApplication.class);
		PersonRepository personRep = context.getBean(PersonRepository.class);
		CarRepository carRep = context.getBean(CarRepository.class);
		personRep.save(new Person("Иван","Иванов"));
		personRep.save(new Person("Андрей","Андреевич"));
		carRep.save(new Car("Lada","Белый",1L));

	}

}

