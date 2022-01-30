package com.rmarrugo.survey.application.usecase;

import com.rmarrugo.survey.faker.SurveyFaker;
import com.rmarrugo.survey.exception.NotFoundException;
import com.rmarrugo.survey.port.out.SurveyFinderRepository;
import com.rmarrugo.survey.usecase.GetSurveyUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@DisplayName("Use case for get survey test")
@ExtendWith(MockitoExtension.class)
class GetSurveyUseCaseTest {

    @Mock
    private SurveyFinderRepository surveyFinderRepository;

    @InjectMocks
    private GetSurveyUseCase getSurveyUseCase;

    @Test
    @DisplayName("all dependencies are provided")
    void allDependenciesAreProvided() {
        Assertions.assertNotNull(surveyFinderRepository);
        Assertions.assertNotNull(getSurveyUseCase);
    }

    @Test
    @DisplayName("when execute get survey then return data")
    void whenExecuteGetSurveyThenReturnData() {
        Mockito.when(surveyFinderRepository.findLast())
                .thenReturn(Optional.of(SurveyFaker.survey()));
        var survey = getSurveyUseCase.execute();
        Mockito.verify(surveyFinderRepository, Mockito.times(1)).findLast();
        Assertions.assertNotNull(survey);
        Assertions.assertEquals(2, survey.getQuestions().size());
    }

    @Test
    @DisplayName("when execute get empty survey then return Exception")
    void whenExecuteGetEmptySurveyThenReturnException() {
        Mockito.when(surveyFinderRepository.findLast())
                .thenReturn(Optional.empty());
        Assertions.assertThrows(NotFoundException.class, () -> getSurveyUseCase.execute());
    }

}
