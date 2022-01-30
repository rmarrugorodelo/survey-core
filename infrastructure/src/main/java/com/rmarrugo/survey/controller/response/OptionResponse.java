package com.rmarrugo.survey.controller.response;

import com.rmarrugo.survey.Option;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class OptionResponse {

    String value;
    String text;

    public static OptionResponse of(Option option) {
        return OptionResponse
                .builder()
                .value(option.getValue())
                .text(option.getText())
                .build();
    }

}
