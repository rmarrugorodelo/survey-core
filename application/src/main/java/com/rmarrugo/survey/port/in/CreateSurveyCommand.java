package com.rmarrugo.survey.port.in;

import com.rmarrugo.survey.Survey;

public interface CreateSurveyCommand {

    void execute(Survey survey);

}
