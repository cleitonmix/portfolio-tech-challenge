package com.ccoimbra.portfoliotechchallenge.portfolio.persistence.repository;

import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
