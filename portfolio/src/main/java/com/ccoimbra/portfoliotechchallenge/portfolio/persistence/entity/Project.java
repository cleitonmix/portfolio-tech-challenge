package com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

@Table("projetos")
@Getter
@Setter
@NoArgsConstructor
public class Project implements Serializable {

    @Id
    private Long id;

    @Column("nome")
    private String name;

    @Column("data_inicio")
    private Date start;

    @Column("data_previsao_fim")
    private Date expectedEnd;

    @Column("data_fim")
    private Date end;

    @Column("descricao")
    private String description;

    private StatusEnum status;

    @Column("orcamento")
    private Double budget;

    @Column("risco")
    private RiskEnum risk;

    @Column("idgerente")
    private Long manageId;

}