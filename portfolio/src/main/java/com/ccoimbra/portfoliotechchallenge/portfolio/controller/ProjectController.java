package com.ccoimbra.portfoliotechchallenge.portfolio.controller;

import com.ccoimbra.portfoliotechchallenge.portfolio.controller.dto.EmployeeResponse;
import com.ccoimbra.portfoliotechchallenge.portfolio.controller.dto.ProjectRequest;
import com.ccoimbra.portfoliotechchallenge.portfolio.controller.dto.ProjectResponse;
import com.ccoimbra.portfoliotechchallenge.portfolio.controller.dto.StatusUpdate;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.EmployeeService;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/v1/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity create(@RequestBody ProjectRequest request) {
        var project = projectService.create(request.toEntity());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(project.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(
        @PathVariable(name = "id") Long id,
        @RequestBody ProjectRequest request
    ) {
        projectService.update(id, request.toEntity());
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/status")
    public ResponseEntity start(
            @PathVariable(name = "id") Long id,
            @RequestBody StatusUpdate statusUpdate
    ) {
        try {
            projectService.updateStatus(id, statusUpdate.status());
            return ResponseEntity.ok().build();
        } catch (UnsupportedOperationException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(
        @PathVariable(name = "id") Long id
    ) {
        projectService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ProjectResponse getById(
        @PathVariable(name = "id") Long id
    ) {
        var optionalProject = projectService.getById(id);

        if (optionalProject.isPresent()) {
            var project = optionalProject.get();
            var employee = employeeService.get(project.getManageId());
            return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getStart(),
                project.getExpectedEnd(),
                project.getEnd(),
                project.getDescription(),
                project.getBudget(),
                project.getRisk(),
                project.getStatus(),
                new EmployeeResponse(employee.id(), employee.name())
            );
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Project not found");
    }
}
