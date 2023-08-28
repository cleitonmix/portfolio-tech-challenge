package com.ccoimbra.portfoliotechchallenge.portfolio.service.state;

public interface ProjectState {

    boolean allowsToDelete();

    void finishAnalysis();

    void approval();

    void start();

    void finishPlanning();

    void execute();

    void finish();

    void cancel();
}