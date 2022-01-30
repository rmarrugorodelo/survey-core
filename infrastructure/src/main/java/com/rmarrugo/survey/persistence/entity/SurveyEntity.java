package com.rmarrugo.survey.persistence.entity;

import com.rmarrugo.survey.Survey;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "surveys")
public class SurveyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    String description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "survey_id")
    List<QuestionEntity> questions = new ArrayList<>();

    public Survey toDomain() {
        return Survey
                .builder()
                .id(id)
                .title(title)
                .description(description)
                .questions(
                        questions
                                .stream()
                                .map(QuestionEntity::toDomain)
                                .collect(Collectors.toList())
                )
                .build();
    }

    public static SurveyEntity of(Survey survey) {
        return SurveyEntity
                .builder()
                .id(survey.getId())
                .title(survey.getTitle())
                .description(survey.getDescription())
                .questions(
                        survey.getQuestions()
                                .stream()
                                .map(QuestionEntity::of)
                                .collect(Collectors.toList())
                )
                .build();
    }

}
