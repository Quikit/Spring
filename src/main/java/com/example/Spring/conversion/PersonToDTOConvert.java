package com.example.Spring.conversion;

import com.example.Spring.dto.PersonDTO;
import com.example.Spring.entity.Person;
import org.springframework.core.convert.converter.Converter;

public class PersonToDTOConvert implements Converter<Person, PersonDTO> {

    @Override
    public PersonDTO convert(Person person) {
        String firstName = person.getFirstName();
        String lastName = person.getLastName();
        return new PersonDTO(firstName,lastName);
    }
}
