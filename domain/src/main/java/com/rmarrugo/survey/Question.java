package com.rmarrugo.survey;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class Question {

    Long id;
    String text;
    QuestionType type;
    List<Option> options;

    public boolean isInvalid() {
        if(QuestionType.MULTIPLE == type){
            return options.isEmpty();
        }
        return false;
    }

}
