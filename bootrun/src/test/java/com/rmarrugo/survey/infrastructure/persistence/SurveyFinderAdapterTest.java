package com.rmarrugo.survey.infrastructure.persistence;

import com.rmarrugo.survey.faker.SurveyFaker;
import com.rmarrugo.survey.persistence.SurveyFinderAdapter;
import com.rmarrugo.survey.persistence.SurveyJpaRepository;
import com.rmarrugo.survey.persistence.entity.SurveyEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@DisplayName("adapter for find survey test")
@ExtendWith(MockitoExtension.class)
class SurveyFinderAdapterTest {

    @Mock
    private SurveyJpaRepository surveyJpaRepository;

    @InjectMocks
    private SurveyFinderAdapter surveyFinderAdapter;

    @Test
    @DisplayName("all dependencies are provided")
    void allDependenciesAreProvided() {
        Assertions.assertNotNull(surveyJpaRepository);
        Assertions.assertNotNull(surveyFinderAdapter);
    }

    @Test
    @DisplayName("when execute get survey then return data")
    void whenExecuteGetSurveyThenReturnData() {
        var entity = SurveyEntity.of(SurveyFaker.survey());
        Mockito.when(surveyJpaRepository.findFirstByOrderByIdAsc())
                .thenReturn(Optional.of(entity));
        var survey = surveyFinderAdapter.findLast();
        Mockito.verify(surveyJpaRepository, Mockito.times(1)).findFirstByOrderByIdAsc();
        Assertions.assertTrue(survey.isPresent());
    }

    @Test
    @DisplayName("when execute get empty survey then return Exception")
    void whenExecuteGetEmptySurveyThenReturnException() {
        Mockito.when(surveyJpaRepository.findFirstByOrderByIdAsc())
                .thenReturn(Optional.empty());
        var survey = surveyFinderAdapter.findLast();
        Mockito.verify(surveyJpaRepository, Mockito.times(1)).findFirstByOrderByIdAsc();
        Assertions.assertTrue(survey.isEmpty());
    }

}
