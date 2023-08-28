package com.ccoimbra.portfoliotechchallenge.portfolio.service.state.impl;

import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.Project;
import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.StatusEnum;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.state.BaseProjectState;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.state.ProjectState;

public class InProgress extends BaseProjectState implements ProjectState {
    public InProgress(Project context) {
        super(context);
    }

    @Override
    public void finish() {
        context.setStatus(StatusEnum.CLOSED);
    }
}