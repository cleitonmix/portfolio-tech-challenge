package com.ccoimbra.portfoliotechchallenge.portfolio.controller.dto;

import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.Project;
import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.RiskEnum;

import java.util.Date;

public record ProjectRequest(
    String name,
    Date start,
    Date expectedEnd,
    Date end,
    String description,
    Double budget,
    String risk,
    Long manageId
){

    public Project toEntity() {
        var entity = new Project();

        entity.setName(name);
        entity.setStart(start);
        entity.setExpectedEnd(expectedEnd);
        entity.setEnd(end);
        entity.setDescription(description);
        entity.setBudget(budget);
        entity.setRisk(risk != null ? RiskEnum.valueOf(risk) : null);
        entity.setManageId(manageId);

        return entity;
    }
}