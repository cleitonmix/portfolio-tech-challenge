package com.ccoimbra.portfoliotechchallenge.portfolio.service.state.impl;

import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.Project;
import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.StatusEnum;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.state.BaseProjectState;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.state.ProjectState;

public class Closed extends BaseProjectState implements ProjectState {
    public Closed(Project context) {
        super(context);
    }

}