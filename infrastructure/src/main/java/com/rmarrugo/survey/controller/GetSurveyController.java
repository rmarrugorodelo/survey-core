package com.rmarrugo.survey.controller;

import com.rmarrugo.survey.controller.response.SurveyResponse;
import com.rmarrugo.survey.port.in.GetSurveysQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1.0/surveys")
@RestController
public class GetSurveyController {

    private final GetSurveysQuery getSurveysQuery;

    @GetMapping
    public SurveyResponse getSurvey() {
        return SurveyResponse.of(getSurveysQuery.execute());
    }

}
