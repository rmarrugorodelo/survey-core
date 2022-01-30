package com.rmarrugo.survey.port.out;

import com.rmarrugo.survey.Survey;

import java.util.Optional;

public interface SurveyFinderRepository {

    Optional<Survey> findLast();

}
