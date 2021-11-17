package com.br.elit.elitProducer.service.impl;

import com.br.elit.elitProducer.models.ReportModel;
import com.br.elit.elitProducer.repository.ReportRepository;
import com.br.elit.elitProducer.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ReportService")
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Override
    public List<ReportModel> getAll() {
        return reportRepository.findAll();
    }

    @Override
    public ReportModel createReport(ReportModel report) {
        return reportRepository.save(report);
    }

    @Override
    public ReportModel updateReport(ReportModel report) {
        return reportRepository.save(report);
    }

    @Override
    public ResponseEntity<Void> deleteById(int reportId) {
        reportRepository.deleteById(reportId);
        return null;
    }
}