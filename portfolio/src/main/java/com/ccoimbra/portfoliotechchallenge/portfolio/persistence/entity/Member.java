package com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity;

import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table("membros")
public class Member implements Serializable {

    private Long projectId;

    private Long personId;
}
