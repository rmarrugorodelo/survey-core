package com.rmarrugo.survey.controller.request;

import com.rmarrugo.survey.Survey;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class SurveyRequest {

    @NotBlank
    String title;

    String description;

    @NotEmpty
    List<@Valid QuestionRequest> questions;

    public Survey toDomain() {
        return Survey
                .builder()
                .title(title)
                .description(description)
                .questions(
                        questions
                                .stream()
                                .map(QuestionRequest::toDomain)
                                .collect(Collectors.toList())
                )
                .build();
    }
}
