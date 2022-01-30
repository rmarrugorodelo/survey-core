package com.rmarrugo.survey.config;

import com.rmarrugo.survey.usecase.CreateSurveyUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SurveyBeanConfig {

    @Bean
    public CreateSurveyUseCase createSurveyUseCase() {
        return new CreateSurveyUseCase();
    }

}
