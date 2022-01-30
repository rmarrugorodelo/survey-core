package com.rmarrugo.survey.controller.response;

import com.rmarrugo.survey.Answer;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class AnswerResponse {

    String value;

    public static AnswerResponse of(Answer answer) {
        return AnswerResponse
                .builder()
                .value(answer.getValue())
                .build();
    }

}
