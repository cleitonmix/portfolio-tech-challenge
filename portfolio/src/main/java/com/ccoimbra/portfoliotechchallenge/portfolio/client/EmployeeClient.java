package com.ccoimbra.portfoliotechchallenge.portfolio.client;

import com.ccoimbra.portfoliotechchallenge.portfolio.client.dto.Employee;
import com.ccoimbra.portfoliotechchallenge.portfolio.client.dto.EmployeeList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class EmployeeClient {

    @Value("${client.person.list-url}")
    private String employeeListUrl;

    @Value("${client.person.get-url}")
    private String employeeGetUrl;

    public List<EmployeeList> list() {
        var restTemplate = new RestTemplate();
        var employee = restTemplate.getForObject(employeeListUrl, EmployeeList[].class);
        return Arrays.stream(employee).toList();
    }

    public Employee get(Long employeeId) {
        var restTemplate = new RestTemplate();
        return restTemplate.getForObject(employeeGetUrl + employeeId, Employee.class);
    }
}
