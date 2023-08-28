package com.ccoimbra.portfoliotechchallenge.portfolio.controller.dto;

import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.StatusEnum;

public record StatusUpdate (
    StatusEnum status
) {
}
