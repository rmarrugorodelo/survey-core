package com.rmarrugo.survey.controller;

import com.rmarrugo.survey.controller.request.SurveyRequest;
import com.rmarrugo.survey.port.in.CreateSurveyCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RequestMapping("/api/v1.0/surveys")
@RestController
public class PostSurveyController {

    private final CreateSurveyCommand createSurveyCommand;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void create(@Valid @RequestBody SurveyRequest surveyRequest) {
        createSurveyCommand.execute(surveyRequest.toDomain());
    }

}
