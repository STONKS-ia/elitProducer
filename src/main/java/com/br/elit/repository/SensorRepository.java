package com.br.elit.repository;

import com.br.elit.models.SensorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<SensorModel, Integer> {
}
