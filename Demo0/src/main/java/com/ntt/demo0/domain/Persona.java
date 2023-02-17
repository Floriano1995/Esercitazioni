package com.ntt.demo0.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
    private long id;
    private String name;
    private String surname;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    //private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
