package com.rmarrugo.survey.infrastructure.persistence;

import com.rmarrugo.survey.faker.SurveyFaker;
import com.rmarrugo.survey.persistence.SurveyJpaRepository;
import com.rmarrugo.survey.persistence.SurveySaverAdapter;
import com.rmarrugo.survey.persistence.entity.SurveyEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("adapter for save survey test")
@ExtendWith(MockitoExtension.class)
class SurveySaverAdapterTest {

    @Mock
    private SurveyJpaRepository surveyJpaRepository;

    @InjectMocks
    private SurveySaverAdapter surveySaverAdapter;

    @Test
    @DisplayName("all dependencies are provided")
    void allDependenciesAreProvided() {
        Assertions.assertNotNull(surveyJpaRepository);
        Assertions.assertNotNull(surveySaverAdapter);
    }

    @Test
    @DisplayName("when execute create survey then save")
    void whenExecuteCreateSurveyThenSave() {
        var survey = SurveyFaker.survey();
        var surveyEntity = SurveyEntity.of(survey);
        Mockito.when(surveyJpaRepository.save(ArgumentMatchers.any())).thenReturn(surveyEntity);
        surveySaverAdapter.save(survey);
        Mockito.verify(surveyJpaRepository, Mockito.times(1)).save(ArgumentMatchers.any());
    }

}
