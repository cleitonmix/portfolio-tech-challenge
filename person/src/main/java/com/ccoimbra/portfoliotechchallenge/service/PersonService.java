package com.ccoimbra.portfoliotechchallenge.service;

import com.ccoimbra.portfoliotechchallenge.persistence.entity.Person;
import com.ccoimbra.portfoliotechchallenge.persistence.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person create(Person entity) {
        return personRepository.save(entity);
    }

    public List<Person> findAll(Boolean employee) {
        if (employee != null) {
            return personRepository.findAllByEmployee(employee);
        }
        return personRepository.findAll();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }
}
