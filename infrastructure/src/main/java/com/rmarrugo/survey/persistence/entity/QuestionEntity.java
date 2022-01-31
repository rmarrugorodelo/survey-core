package com.rmarrugo.survey.persistence.entity;

import com.rmarrugo.survey.Question;
import com.rmarrugo.survey.QuestionType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "questions")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String text;

    @Enumerated(EnumType.STRING)
    QuestionType type;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    List<OptionEntity> options = new ArrayList<>();

    public Question toDomain() {
        return Question
                .builder()
                .id(id)
                .text(text)
                .type(type)
                .options(
                        options
                                .stream()
                                .map(OptionEntity::toDomain)
                                .collect(Collectors.toList())
                )
                .build();
    }

    public static QuestionEntity of(Question question) {
        return QuestionEntity
                .builder()
                .id(question.getId())
                .text(question.getText())
                .type(question.getType())
                .options(
                        question.getOptions()
                                .stream()
                                .map(OptionEntity::of)
                                .collect(Collectors.toList())
                )
                .build();
    }

}
