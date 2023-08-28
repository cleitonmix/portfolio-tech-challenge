package com.ccoimbra.portfoliotechchallenge.portfolio.service;

import com.ccoimbra.portfoliotechchallenge.portfolio.client.EmployeeClient;
import com.ccoimbra.portfoliotechchallenge.portfolio.client.dto.Employee;
import com.ccoimbra.portfoliotechchallenge.portfolio.client.dto.EmployeeList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeClient client;

    public List<EmployeeList> list() {
        return client.list();
    }

    public Employee get(Long employeeId) {
        return client.get(employeeId);
    }
}
