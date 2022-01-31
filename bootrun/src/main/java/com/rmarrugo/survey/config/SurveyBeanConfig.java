package com.rmarrugo.survey.config;

import com.rmarrugo.survey.port.out.SurveyFinderRepository;
import com.rmarrugo.survey.port.out.SurveySaverRepository;
import com.rmarrugo.survey.usecase.CreateSurveyUseCase;
import com.rmarrugo.survey.usecase.GetSurveyUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SurveyBeanConfig {

    @Bean
    public CreateSurveyUseCase createSurveyUseCase(SurveySaverRepository surveySaverRepository) {
        return new CreateSurveyUseCase(surveySaverRepository);
    }

    @Bean
    public GetSurveyUseCase getSurveyUseCase(SurveyFinderRepository surveyFinderRepository) {
        return new GetSurveyUseCase(surveyFinderRepository);
    }

}
