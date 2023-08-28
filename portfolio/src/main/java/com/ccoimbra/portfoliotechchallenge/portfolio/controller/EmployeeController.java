package com.ccoimbra.portfoliotechchallenge.portfolio.controller;

import com.ccoimbra.portfoliotechchallenge.portfolio.controller.dto.EmployeeResponse;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<EmployeeResponse> list() {
        return employeeService
                .list()
                .stream()
                .map(it -> new EmployeeResponse(it.id(), it.name()))
                .collect(Collectors.toList());
    }
}