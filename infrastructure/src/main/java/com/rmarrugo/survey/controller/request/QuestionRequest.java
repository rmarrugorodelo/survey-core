package com.rmarrugo.survey.controller.request;

import com.rmarrugo.survey.Question;
import com.rmarrugo.survey.QuestionType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class QuestionRequest {

    @NotBlank
    String text;

    @NotBlank
    String type;

    public Question toDomain() {
        return Question
                .builder()
                .text(text)
                .type(QuestionType.of(type))
                .build();
    }

}
