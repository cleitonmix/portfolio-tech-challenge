package com.ccoimbra.portfoliotechchallenge.portfolio.service.state.impl;

import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.Project;
import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.StatusEnum;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.state.BaseProjectState;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.state.ProjectState;

public class Planned extends BaseProjectState implements ProjectState {
    public Planned(Project context) {
        super(context);
    }

    @Override
    public boolean allowsToDelete() {
        return true;
    }

    @Override
    public void execute() {
        context.setStatus(StatusEnum.IN_PROGRESS);
    }

    @Override
    public void cancel() {
        context.setStatus(StatusEnum.CANCELED);
    }
}