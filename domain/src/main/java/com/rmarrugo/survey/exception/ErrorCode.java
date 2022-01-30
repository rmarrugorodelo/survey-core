package com.rmarrugo.survey.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {

    BAD_REQUEST(400, ""),
    INVALID_QUESTION_TYPE(100, "Tipo de pregunta no es valido");

    int value;
    String reasonPhrase;

    ErrorCode(int value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

}
