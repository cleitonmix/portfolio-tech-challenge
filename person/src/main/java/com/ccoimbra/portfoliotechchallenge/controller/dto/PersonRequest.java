package com.ccoimbra.portfoliotechchallenge.controller.dto;

import com.ccoimbra.portfoliotechchallenge.persistence.entity.Person;
import org.springframework.data.relational.core.mapping.Column;

import java.util.Date;

public record PersonRequest(
    String name,
    Date birthday,
    String document,
    Boolean employee
){

    public Person toEntity() {
        var entity = new Person();

        entity.setName(name);
        entity.setBirthday(birthday);
        entity.setDocument(document);
        entity.setEmployee(employee);

        return entity;
    }
}