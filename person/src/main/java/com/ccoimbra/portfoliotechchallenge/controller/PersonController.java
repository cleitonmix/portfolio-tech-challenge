package com.ccoimbra.portfoliotechchallenge.controller;

import com.ccoimbra.portfoliotechchallenge.controller.dto.PersonRequest;
import com.ccoimbra.portfoliotechchallenge.controller.dto.PersonResponse;
import com.ccoimbra.portfoliotechchallenge.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    public ResponseEntity create(@RequestBody PersonRequest request) {
        var person = personService.create(request.toEntity());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(person.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public List<PersonResponse> findAll(
        @RequestParam(name = "employee", required = false) Boolean employee
    ) {
        return personService
                .findAll(employee)
                .stream()
                .map(it -> new PersonResponse(
                        it.getId(),
                        it.getName(),
                        it.getBirthday(),
                        it.getDocument(),
                        it.getEmployee()
                    ))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PersonResponse findById(
        @PathVariable(name = "id") Long id
    ) {
        return personService
                .findById(id)
                .map(it -> new PersonResponse(
                        it.getId(),
                        it.getName(),
                        it.getBirthday(),
                        it.getDocument(),
                        it.getEmployee()
                ))
                .orElse(null);
    }
}
