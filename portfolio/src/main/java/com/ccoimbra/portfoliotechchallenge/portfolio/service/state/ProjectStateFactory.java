package com.ccoimbra.portfoliotechchallenge.portfolio.service.state;

import com.ccoimbra.portfoliotechchallenge.portfolio.persistence.entity.Project;
import com.ccoimbra.portfoliotechchallenge.portfolio.service.state.impl.*;

public class ProjectStateFactory {

    public static ProjectState fromProject (Project context) {
        return switch (context.getStatus()) {
            case IN_ANALYSIS -> new InAnalysis(context);
            case ANALYSIS_PERFORMED -> new AnalysisPerformed(context);
            case ANALYSIS_APPROVAL -> new AnalysisAppoval(context);
            case STARTED -> new Started(context);
            case PLANNED -> new Planned(context);
            case IN_PROGRESS -> new InProgress(context);
            case CLOSED -> new Closed(context);
            case CANCELED -> new Canceled(context);
        };
    }
}
