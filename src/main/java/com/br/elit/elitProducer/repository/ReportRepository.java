package com.br.elit.elitProducer.repository;

import com.br.elit.elitProducer.models.ReportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportRepository extends JpaRepository<ReportModel, Integer> {

    @Query("SELECT r FROM ReportModel r " +
            "WHERE (r.reportId = ?1 OR ?1 IS NULL) " +
            "AND (r.phStatus LIKE concat('%', ?2, '%') OR ?2 IS NULL) " +
            "AND (r.turbidityStatus LIKE concat('%', ?3, '%') OR ?3 IS NULL) " +
            "AND (r.alkalinityStatus LIKE concat('%', ?4, '%') OR ?4 IS NULL) ")
    List<ReportModel> findAllFilter(int reportId, String phStatus,String turbidityStatus,String alkalinityStatus);
}
