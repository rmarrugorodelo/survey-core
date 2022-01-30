package com.rmarrugo.survey;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class Survey {

    Long id;
    String title;
    String description;
    List<Question> questions;

    public boolean isValid() {
        return this.questions
                .parallelStream()
                .noneMatch(Question::isInvalid);
    }

}
