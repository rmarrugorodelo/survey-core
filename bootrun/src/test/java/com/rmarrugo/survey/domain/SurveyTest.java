package com.rmarrugo.survey.domain;


import com.rmarrugo.survey.faker.SurveyFaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Suvey test")
class SurveyTest {

    @Test
    @DisplayName("when a valid survey then return True ")
    void whenValidateQuestionReturnTrue() {
        var isValid = SurveyFaker.survey().isValid();
        Assertions.assertTrue(isValid);
    }

    @Test
    @DisplayName("when a invalid survey then return False ")
    void whenvalidateQuestionReturnFalse() {
        var isValid = SurveyFaker.invalidSurvey().isValid();
        Assertions.assertFalse(isValid);
    }
}
