package com.ccoimbra.portfoliotechchallenge.persistence.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;

@Table("pessoas")
@Getter
@Setter
@NoArgsConstructor
public class Person implements Serializable {

    @Id
    private Long id;

    @Column("nome")
    private String name;

    @Column("datanascimento")
    private Date birthday;

    @Column("cpf")
    private String document;

    @Column("funcionario")
    private Boolean employee;
}