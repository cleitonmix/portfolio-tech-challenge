package com.ccoimbra.portfoliotechchallenge.portfolio.service.state.impl;

import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.Project;
import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.StatusEnum;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.state.BaseProjectState;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.state.ProjectState;

public class AnalysisPerformed extends BaseProjectState implements ProjectState {
    public AnalysisPerformed(Project context) {
        super(context);
    }

    @Override
    public boolean allowsToDelete() {
        return true;
    }

    @Override
    public void approval() {
        context.setStatus(StatusEnum.ANALYSIS_APPROVAL);
    }

    @Override
    public void cancel() {
        context.setStatus(StatusEnum.CANCELED);
    }
}
