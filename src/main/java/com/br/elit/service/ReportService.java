package com.br.elit.service;

import com.br.elit.models.ReportModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ReportService {

    List<ReportModel> getAll();
    ReportModel createReport(ReportModel report);
    ReportModel updateReport(ReportModel report);
    ResponseEntity<Void> deleteById(int reportId);
}
