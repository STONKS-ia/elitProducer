package com.br.elit.elitProducer.repository;

import com.br.elit.elitProducer.models.ReportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<ReportModel, Integer> {
}
