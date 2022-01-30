package com.rmarrugo.survey.port.in;

import com.rmarrugo.survey.Survey;

import java.util.List;

public interface GetSurveysQuery {

    List<Survey> execute(Survey survey);
}
