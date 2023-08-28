package com.ccoimbra.portfoliotechchallenge.controller.dto;

import java.util.Date;

public record PersonResponse (
    Long id,
    String name,
    Date birthday,
    String document,
    Boolean employee
) {}
