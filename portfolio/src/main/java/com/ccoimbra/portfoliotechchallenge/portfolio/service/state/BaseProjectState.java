package com.ccoimbra.portfoliotechchallenge.portfolio.service.state;

import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.Project;
import lombok.Getter;

@Getter
public abstract class BaseProjectState {

    protected Project context;

    protected BaseProjectState(Project context) {
        this.context = context;
    }

    public boolean allowsToDelete() {
        return false;
    }

    public void finishAnalysis() {
        throw new UnsupportedOperationException();
    }

    public void approval() {
        throw new UnsupportedOperationException();
    }

    public void start() {
        throw new UnsupportedOperationException();
    }

    public void finishPlanning() {
        throw new UnsupportedOperationException();
    }

    public void execute() {
        throw new UnsupportedOperationException();
    }

    public void finish() {
        throw new UnsupportedOperationException();
    }

    public void cancel() {
        throw new UnsupportedOperationException();
    }
}
