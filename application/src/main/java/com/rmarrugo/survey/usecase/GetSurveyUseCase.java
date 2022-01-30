package com.rmarrugo.survey.usecase;

import com.rmarrugo.survey.Survey;
import com.rmarrugo.survey.port.in.GetSurveysQuery;

import java.util.Collections;
import java.util.List;

public class GetSurveyUseCase implements GetSurveysQuery {

    @Override
    public List<Survey> execute(Survey survey) {
        return Collections.emptyList();
    }

}
