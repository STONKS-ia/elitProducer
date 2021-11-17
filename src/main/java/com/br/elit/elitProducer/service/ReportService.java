package com.br.elit.elitProducer.service;

import com.br.elit.elitProducer.models.ReportModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReportService {

    List<ReportModel> getAll();
    ReportModel getById(int reportId);
    ReportModel createReport(ReportModel report);
    ReportModel updateReport(ReportModel report);
    ResponseEntity<Void> deleteById(int reportId);
}
