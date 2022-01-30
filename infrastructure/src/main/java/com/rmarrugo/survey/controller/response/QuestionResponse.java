package com.rmarrugo.survey.controller.response;

import com.rmarrugo.survey.Answer;
import com.rmarrugo.survey.Question;
import com.rmarrugo.survey.QuestionType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class QuestionResponse {

    String text;
    String type;
    List<AnswerResponse> answers;

    public static QuestionResponse of(Question question) {
        return QuestionResponse
                .builder()
                .text(question.getText())
                .type(question.getType().name())
                .answers(
                        question.getAnswers()
                                .stream()
                                .map(AnswerResponse::of)
                                .collect(Collectors.toList())
                )
                .build();
    }

}
