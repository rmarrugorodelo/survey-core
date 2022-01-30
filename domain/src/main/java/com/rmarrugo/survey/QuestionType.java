package com.rmarrugo.survey;

import com.rmarrugo.survey.exception.BadRequestException;
import com.rmarrugo.survey.exception.ErrorCode;

public enum QuestionType {

    OPEN, MULTIPLE;

    public static QuestionType of(String state) {
        try {
            return QuestionType.valueOf(state);
        } catch (RuntimeException e) {
            throw new BadRequestException(ErrorCode.INVALID_QUESTION_TYPE);
        }
    }

}
