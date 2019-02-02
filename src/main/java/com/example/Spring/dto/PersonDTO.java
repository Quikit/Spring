package com.example.Spring.dto;

import lombok.Data;

@Data
public class PersonDTO {
    private long id;
    private String firstName;
    private String lastName;

    protected PersonDTO() {}

    public PersonDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Person[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }
}
