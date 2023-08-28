package com.ccoimbra.portfoliotechchallenge.portfolio.service;

import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.Project;
import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.StatusEnum;
import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.repository.ProjectRepository;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.state.ProjectState;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.state.ProjectStateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeService employeeService;

    public Project create(Project entity) {
        validateManage(entity);
        entity.setStatus(StatusEnum.IN_ANALYSIS);
        return projectRepository.save(entity);
    }

    private void validateManage(Project entity) {
        var manage = employeeService.get(entity.getManageId());
        if (manage == null || manage.employee() == null || !manage.employee()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Manage not found");
        }
    }

    public void update(Long id, Project entity) {
        var project = getProjectById(id);
        validateManage(entity);
        entity.setId(id);
        entity.setStatus(project.getStatus());
        projectRepository.save(entity);
    }

    public Optional<Project> getById(Long id) {
        return projectRepository.findById(id);
    }

    public void delete(Long id) {
        var project = getProjectById(id);
        var state = ProjectStateFactory.fromProject(project);
        if (!state.allowsToDelete()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        projectRepository.delete(project);
    }

    public void updateStatus(Long projectId, StatusEnum newStatus) {
        var project = getProjectById(projectId);
        var state = ProjectStateFactory.fromProject(project);

        switch (newStatus) {
            case IN_ANALYSIS -> throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            case ANALYSIS_PERFORMED -> state.finishAnalysis();
            case ANALYSIS_APPROVAL -> state.approval();
            case STARTED -> state.start();
            case PLANNED -> state.finishPlanning();
            case IN_PROGRESS -> state.execute();
            case CLOSED -> state.finish();
            case CANCELED -> state.cancel();
        }

        projectRepository.save(project);
    }

    private Project getProjectById(Long id) {
        var optionalProject = projectRepository.findById(id);

        if (!optionalProject.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return optionalProject.get();
    }
}
