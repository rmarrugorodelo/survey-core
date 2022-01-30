package com.rmarrugo.survey.application.usecase;

import com.rmarrugo.survey.faker.SurveyFaker;
import com.rmarrugo.survey.exception.BadRequestException;
import com.rmarrugo.survey.port.out.SurveySaverRepository;
import com.rmarrugo.survey.usecase.CreateSurveyUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Use case for create survey test")
@ExtendWith(MockitoExtension.class)
class CreateSurveyUseCaseTest{

    @Mock
    private SurveySaverRepository surveySaverRepository;

    @InjectMocks
    private CreateSurveyUseCase createSurveyUseCase;

    @Test
    @DisplayName("all dependencies are provided")
    void allDependenciesAreProvided() {
        Assertions.assertNotNull(surveySaverRepository);
        Assertions.assertNotNull(createSurveyUseCase);
    }

    @Test
    @DisplayName("when execute create survey then save")
    void whenExecuteCreateSurveyThenSave() {
        var survey = SurveyFaker.survey();
        Mockito.doNothing().when(surveySaverRepository).save(survey);
        createSurveyUseCase.execute(survey);
        Mockito.verify(surveySaverRepository, Mockito.times(1)).save(survey);
    }

    @Test
    @DisplayName("when execute create invalid survey then return exception")
    void whenExecuteCreateInvalidSurveyThenReturnException() {
        var survey = SurveyFaker.invalidSurvey();
        Assertions.assertThrows(BadRequestException.class, () -> createSurveyUseCase.execute(survey));
    }

}
