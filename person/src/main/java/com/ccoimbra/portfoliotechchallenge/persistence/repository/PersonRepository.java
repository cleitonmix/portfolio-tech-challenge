package com.ccoimbra.portfoliotechchallenge.persistence.repository;

import com.ccoimbra.portfoliotechchallenge.persistence.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAllByEmployee(Boolean employee);

    List<Person> findAll();

}
