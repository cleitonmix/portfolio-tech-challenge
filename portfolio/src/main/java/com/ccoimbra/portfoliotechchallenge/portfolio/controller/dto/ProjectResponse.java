package com.ccoimbra.portfoliotechchallenge.portfolio.controller.dto;

import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.RiskEnum;
import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.StatusEnum;

import java.util.Date;

public record ProjectResponse(
    Long id,
    String name,
    Date start,
    Date expectedEnd,
    Date end,
    String description,
    Double budget,
    RiskEnum risk,
    StatusEnum status,
    EmployeeResponse manage
) {
}
