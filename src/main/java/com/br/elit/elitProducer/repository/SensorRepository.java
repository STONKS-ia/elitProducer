package com.br.elit.elitProducer.repository;

import com.br.elit.elitProducer.models.ReportModel;
import com.br.elit.elitProducer.models.SensorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<SensorModel, Integer> {

    @Query("SELECT s FROM SensorModel s " +
            "WHERE (s.sensorId = ?1 OR ?1 IS NULL) " +
            "AND (s.material LIKE concat('%', ?2, '%') OR ?2 IS NULL) " +
            "AND (s.serialNumber LIKE concat('%', ?3, '%') OR ?3 IS NULL) " +
            "AND (s.manufacturer LIKE concat('%', ?4, '%') OR ?4 IS NULL) ")
    List<SensorModel> findAllFilter(int sensorId, String material, String serialNumber, String manufacturer);
}
