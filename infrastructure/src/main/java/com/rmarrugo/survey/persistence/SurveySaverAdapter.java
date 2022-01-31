package com.rmarrugo.survey.persistence;

import com.rmarrugo.survey.Survey;
import com.rmarrugo.survey.persistence.entity.SurveyEntity;
import com.rmarrugo.survey.port.out.SurveySaverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class SurveySaverAdapter implements SurveySaverRepository {

    private final SurveyJpaRepository surveyJpaRepository;

    @Override
    public void save(Survey survey) {
        surveyJpaRepository.save(SurveyEntity.of(survey));
    }

}
