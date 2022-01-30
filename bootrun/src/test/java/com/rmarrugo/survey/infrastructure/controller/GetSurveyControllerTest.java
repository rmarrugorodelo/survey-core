package com.rmarrugo.survey.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmarrugo.survey.controller.GetSurveyController;
import com.rmarrugo.survey.controller.response.SurveyResponse;
import com.rmarrugo.survey.exception.ErrorCode;
import com.rmarrugo.survey.exception.NotFoundException;
import com.rmarrugo.survey.faker.SurveyFaker;
import com.rmarrugo.survey.faker.SurveyRequestFaker;
import com.rmarrugo.survey.port.in.GetSurveysQuery;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@DisplayName("Controller for get request test")
@WebMvcTest(GetSurveyController.class)
@ExtendWith(SpringExtension.class)
class GetSurveyControllerTest {

    private static final String GET_PATH = "/api/v1.0/surveys";

    @MockBean
    private GetSurveysQuery getSurveysQuery;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("when get empty survey then return Exeption")
    void whenGetEmptySurveyThenReturnExeption() throws Exception {
        Mockito.when(getSurveysQuery.execute()).thenThrow(new NotFoundException(ErrorCode.SURVEY_NOT_FOUND));
        var body = objectMapper.writeValueAsString(SurveyRequestFaker.surveyWithInvalidTitle());
        mockMvc.perform(
                MockMvcRequestBuilders.get(GET_PATH))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound());
    }


    @Test
    @DisplayName("when get survey then return data")
    void whenGetSurveyThenReturnData() throws Exception {
        var survey = SurveyFaker.survey();
        Mockito.when(getSurveysQuery.execute()).thenReturn(survey);
        var content = objectMapper.writeValueAsString(SurveyResponse.of(survey));
        mockMvc.perform(
                MockMvcRequestBuilders.get(GET_PATH))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(content));
    }

}
