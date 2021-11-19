package com.br.elit.elitProducer.repository;

import com.br.elit.elitProducer.models.SensorModel;
import com.br.elit.elitProducer.models.StateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StateRepository extends JpaRepository<StateModel, Integer> {

    @Query("SELECT s FROM StateModel s " +
            "WHERE (s.stateId = ?1 OR ?1 IS NULL) " +
            "AND (s.name LIKE concat('%', ?2, '%') OR ?2 IS NULL) " +
            "AND (s.acronymState LIKE concat('%', ?3, '%') OR ?3 IS NULL) " +
            "AND (s.region LIKE concat('%', ?4, '%') OR ?4 IS NULL) ")
    List<StateModel> findAllFilter(int stateId, String name, String acronymState, String region);
}
