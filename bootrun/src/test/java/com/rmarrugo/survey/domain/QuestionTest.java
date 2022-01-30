package com.rmarrugo.survey.domain;


import com.rmarrugo.survey.faker.SurveyFaker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Question test")
class QuestionTest {

    @Test
    @DisplayName("when a invalid question then return True")
    void whenValidateQuestionReturnTrue() {
        var question = SurveyFaker.invalidQuestion();
        Assertions.assertTrue(question.isInvalid());
    }

    @Test
    @DisplayName("when a valid question then return False")
    void whenvalidateQuestionReturnFalse() {
        var question = SurveyFaker.survey().getQuestions().get(0);
        Assertions.assertFalse(question.isInvalid());
    }
}
