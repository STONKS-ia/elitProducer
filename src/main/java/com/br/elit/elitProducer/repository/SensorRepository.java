package com.br.elit.elitProducer.repository;

import com.br.elit.elitProducer.models.SensorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<SensorModel, Integer> {
}
