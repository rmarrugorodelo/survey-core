package com.rmarrugo.survey;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public final class PageAsk {

    Integer page;
    Integer size;

    private PageAsk(Integer page, Integer size) {
        this.page = page;
        this.size = size;
    }

    public static PageAsk create(Integer page, Integer size) {
        return new PageAsk(page, size);
    }

}
