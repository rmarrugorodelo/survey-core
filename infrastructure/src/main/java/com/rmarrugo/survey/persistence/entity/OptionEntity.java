package com.rmarrugo.survey.persistence.entity;

import com.rmarrugo.survey.Option;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "options")
public class OptionEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long value;
    String text;

    public Option toDomain() {
        return Option
                .builder()
                .value(value)
                .text(text)
                .build();
    }

    public static OptionEntity of(Option option) {
        return OptionEntity
                .builder()
                .value(option.getValue())
                .text(option.getText())
                .build();
    }

}
