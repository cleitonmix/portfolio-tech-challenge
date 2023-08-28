package com.ccoimbra.portfoliotechchallenge.portfolio.service.state.impl;

import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.Project;
import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.StatusEnum;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.state.BaseProjectState;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.state.ProjectState;

public class AnalysisAppoval extends BaseProjectState implements ProjectState {
    public AnalysisAppoval(Project context) {
        super(context);
    }

    @Override
    public boolean allowsToDelete() {
        return true;
    }

    @Override
    public void start() {
        context.setStatus(StatusEnum.STARTED);
    }
}
