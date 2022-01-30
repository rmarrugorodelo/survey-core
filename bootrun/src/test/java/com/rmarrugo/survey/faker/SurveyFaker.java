package com.rmarrugo.survey.faker;

import com.rmarrugo.survey.Option;
import com.rmarrugo.survey.Question;
import com.rmarrugo.survey.QuestionType;
import com.rmarrugo.survey.Survey;
import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.List;

@UtilityClass
public class SurveyFaker {

    private final String TITLE = "Esto es una encuesta";
    private final String DESCRIPTION = "Se recogeran datos de prueba para medi test";

    public Survey survey() {
        return Survey
                .builder()
                .title(TITLE)
                .description(DESCRIPTION)
                .questions(
                        List.of(
                                question(QuestionType.OPEN, Collections.emptyList()),
                                question(QuestionType.MULTIPLE, options())
                        )
                )
                .build();
    }

    public Survey invalidSurvey() {
        return Survey
                .builder()
                .title(TITLE)
                .description(DESCRIPTION)
                .questions(
                        List.of(
                                question(QuestionType.OPEN, Collections.emptyList()),
                                invalidQuestion()
                        )
                )
                .build();
    }

    public Question invalidQuestion() {
        return  question(QuestionType.MULTIPLE, Collections.emptyList());
    }

    private Question question(QuestionType questionType, List<Option> options) {
        return Question
                .builder()
                .type(questionType)
                .text("Cuando fue la última vez que visitó al doctor?")
                .options(options)
                .build();

    }

    private List<Option> options() {
        return List.of(
                Option
                        .builder()
                        .value("1")
                        .text("Opción 1")
                        .build(),
                Option
                        .builder()
                        .value("2")
                        .text("Opción 2")
                        .build()
        );
    }

}
