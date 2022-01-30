package com.rmarrugo.survey.usecase;

import com.rmarrugo.survey.Survey;
import com.rmarrugo.survey.exception.ErrorCode;
import com.rmarrugo.survey.exception.NotFoundException;
import com.rmarrugo.survey.port.in.GetSurveysQuery;
import com.rmarrugo.survey.port.out.SurveyFinderRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetSurveyUseCase implements GetSurveysQuery {

    private final SurveyFinderRepository surveyFinderRepository;

    @Override
    public Survey execute() {
        return surveyFinderRepository.findLast()
                .orElseThrow(() -> new NotFoundException(ErrorCode.SURVEY_NOT_FOUND));
    }

}
