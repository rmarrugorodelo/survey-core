package com.rmarrugo.survey.persistence;

import com.rmarrugo.survey.Survey;
import com.rmarrugo.survey.persistence.entity.SurveyEntity;
import com.rmarrugo.survey.port.out.SurveyFinderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class SurveyFinderAdapter implements SurveyFinderRepository {

    private final SurveyJpaRepository surveyJpaRepository;

    @Override
    public Optional<Survey> findLast() {
        return surveyJpaRepository.findFirstByOrderByIdAsc()
                .map(SurveyEntity::toDomain);
    }

}
