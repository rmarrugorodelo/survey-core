package com.rmarrugo.survey.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rmarrugo.survey.controller.PostSurveyController;
import com.rmarrugo.survey.faker.SurveyRequestFaker;
import com.rmarrugo.survey.port.in.CreateSurveyCommand;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@DisplayName("Controller for post request test")
@WebMvcTest(PostSurveyController.class)
@ExtendWith(SpringExtension.class)
class PostSurveyControllerTest {

    private static final String CREATE_PATH = "/api/v1.0/surveys";

    @MockBean
    private CreateSurveyCommand createSurveyCommand;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("when create with invalid title then return Exeption")
    void whenCreateWithInvalidTitleThenReturnExeption() throws Exception {
        var body = objectMapper.writeValueAsString(SurveyRequestFaker.surveyWithInvalidTitle());
        mockMvc.perform(
                MockMvcRequestBuilders.post(CREATE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
        ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("when create without questions then return Exeption")
    void whenCreateWithoutQuestionsThenReturnExeption() throws Exception {
        var body = objectMapper.writeValueAsString(SurveyRequestFaker.surveyWithoutQuestions());
        mockMvc.perform(
                MockMvcRequestBuilders.post(CREATE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
        ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("when create with invalid question then return Exeption")
    void whenCreateWithInvalidQuestionThenReturnExeption() throws Exception {
        var body = objectMapper.writeValueAsString(SurveyRequestFaker.surveyWithInvalidQuestionsRequest());
        mockMvc.perform(
                MockMvcRequestBuilders.post(CREATE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
        ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("when create survey then return ok")
    void whenCreateSurveyThenReturnOk() throws Exception {
        var body = objectMapper.writeValueAsString(SurveyRequestFaker.survey());
        mockMvc.perform(
                MockMvcRequestBuilders.post(CREATE_PATH)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body)
        ).andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

}
