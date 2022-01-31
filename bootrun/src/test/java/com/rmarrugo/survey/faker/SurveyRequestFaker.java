package com.rmarrugo.survey.faker;

import com.rmarrugo.survey.QuestionType;
import com.rmarrugo.survey.controller.request.SurveyRequest;
import com.rmarrugo.survey.controller.request.SurveyRequest.OptionRequest;
import com.rmarrugo.survey.controller.request.SurveyRequest.QuestionRequest;
import lombok.experimental.UtilityClass;

import java.util.Collections;
import java.util.List;

@UtilityClass
public class SurveyRequestFaker {

    private final String TITLE = "Esto es una encuesta";
    private final String DESCRIPTION = "Se recogeran datos de prueba para medi test";

    public SurveyRequest survey() {
        return survey(TITLE,
                List.of(
                        question(QuestionType.OPEN.name(), Collections.emptyList()),
                        question(QuestionType.MULTIPLE.name(), options())
                )
        );
    }

    public SurveyRequest surveyWithInvalidTitle() {
        return survey(null,
                List.of(
                        question(QuestionType.OPEN.name(), Collections.emptyList()),
                        question(QuestionType.MULTIPLE.name(), options())
                )
        );
    }

    public SurveyRequest surveyWithoutQuestions() {
        return survey(TITLE, Collections.emptyList());
    }

    public SurveyRequest surveyWithInvalidQuestionsRequest() {
        return survey(TITLE, List.of(
                question("", Collections.emptyList())
        ));
    }


    private SurveyRequest survey(String title,
                                 List<QuestionRequest> questions) {
        return SurveyRequest
                .builder()
                .title(title)
                .description(DESCRIPTION)
                .questions(questions)
                .build();
    }


    private QuestionRequest question(String questionType, List<OptionRequest> options) {
        return QuestionRequest
                .builder()
                .type(questionType)
                .text("Cuando fue la última vez que visitó al doctor?")
                .options(options)
                .build();

    }

    private List<OptionRequest> options() {
        return List.of(
                OptionRequest
                        .builder()
                        .value("1")
                        .text("Opción 1")
                        .build(),
                OptionRequest
                        .builder()
                        .value("2")
                        .text("Opción 2")
                        .build()
        );
    }

}
