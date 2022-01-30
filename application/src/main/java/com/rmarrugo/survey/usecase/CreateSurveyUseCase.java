package com.rmarrugo.survey.usecase;

import com.rmarrugo.survey.Survey;
import com.rmarrugo.survey.port.in.CreateSurveyCommand;
import com.rmarrugo.survey.port.out.SurveySaverRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateSurveyUseCase implements CreateSurveyCommand {

    private final SurveySaverRepository surveySaverRepository;

    @Override
    public void execute(Survey survey) {
        surveySaverRepository.save(survey);
    }

}
