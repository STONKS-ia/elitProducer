package com.br.elit.elitProducer.service.impl;

import com.br.elit.elitProducer.business.ProducerBusiness;
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

    @Autowired
    private ProducerBusiness producerBusiness;

    @Override
    public List<ReportModel> getAll() {
        return reportRepository.findAll();
    }

    @Override
    public List<ReportModel> getAllByFilter(int reportId, String phStatus,String turbidityStatus,String alkalinityStatus) {
        if(phStatus.isEmpty())
            phStatus = null;
        if(turbidityStatus.isEmpty())
            turbidityStatus = null;
        if(alkalinityStatus.isEmpty())
            alkalinityStatus = null;

        return reportRepository.findAllFilter(reportId, phStatus, turbidityStatus, alkalinityStatus);
    }

    @Override
    public ReportModel getById(int reportId) {
        return reportRepository.getById(reportId);
    };

    @Override
    public ReportModel createReport(ReportModel report) {

        producerBusiness.applyBusiness(report);
        return reportRepository.save(report);
    }

    @Override
    public ReportModel updateReport(ReportModel report) {

        producerBusiness.applyBusiness(report);

        return reportRepository.save(report);
    }

    @Override
    public ResponseEntity<Void> deleteById(int reportId) {
        reportRepository.deleteById(reportId);
        return null;
    }
}