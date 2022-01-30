package com.rmarrugo.survey.controller.request;

import com.rmarrugo.survey.Option;
import com.rmarrugo.survey.Question;
import com.rmarrugo.survey.QuestionType;
import com.rmarrugo.survey.Survey;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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

    @Getter
    @Builder
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    private static final class QuestionRequest {

        @NotBlank
        String text;

        @NotBlank
        String type;

        List<@Valid OptionRequest> options;

        public Question toDomain() {
            return Question
                    .builder()
                    .text(text)
                    .type(QuestionType.of(type))
                    .options(OptionRequest.toDomain(options))
                    .build();
        }

    }

    @Getter
    @Builder
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    private static final class OptionRequest {

        @NotNull
        Long value;

        @NotBlank
        String text;

        public static List<Option> toDomain(List<OptionRequest> options) {
            if (Objects.nonNull(options)) {
                return options
                        .stream()
                        .map(OptionRequest::toDomain)
                        .collect(Collectors.toList());
            } else {
                return Collections.emptyList();
            }
        }

        public Option toDomain() {
            return Option
                    .builder()
                    .text(text)
                    .value(value)
                    .build();
        }

    }

}
