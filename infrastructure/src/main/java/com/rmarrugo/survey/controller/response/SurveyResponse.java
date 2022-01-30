package com.rmarrugo.survey.controller.response;

import com.rmarrugo.survey.Survey;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class SurveyResponse {

    String title;
    String description;
    List<QuestionResponse> questions;

    public static SurveyResponse of(Survey survey) {
        return SurveyResponse
                .builder()
                .title(survey.getTitle())
                .description(survey.getDescription())
                .questions(
                        survey.getQuestions()
                                .stream()
                                .map(QuestionResponse::of)
                                .collect(Collectors.toList())
                )
                .build();
    }

}
