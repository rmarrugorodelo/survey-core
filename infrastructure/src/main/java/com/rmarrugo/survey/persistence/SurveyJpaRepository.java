package com.rmarrugo.survey.persistence;

import com.rmarrugo.survey.persistence.entity.SurveyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SurveyJpaRepository extends CrudRepository<SurveyEntity, Long> {

    Optional<SurveyEntity> findFirstByOrderByIdAsc();

}
