package com.br.elit.elitProducer.controller;

import com.br.elit.elitProducer.exception.ApiException;
import com.br.elit.elitProducer.models.ReportModel;
import com.br.elit.elitProducer.service.ReportService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    public ReportService reportService;

    @GetMapping
    @ApiOperation(value = "Return a list with all reports")
    public ResponseEntity<List<ReportModel>> getAll() {

        List<ReportModel> reports = reportService.getAll();

        return ResponseEntity.ok(reports);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Return a report by id")
    public ResponseEntity<ReportModel> findById(@PathVariable("id") int id) {

        ReportModel report = reportService.getById(id);

        return ResponseEntity.ok(report);
    }

    @PostMapping()
    public ResponseEntity<String> save(@RequestBody @Valid ReportModel report) {
        ReportModel reportSaved =  reportService.createReport(report);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(report.getId()).toUri();

        return ResponseEntity.created(location).header("Created").body("Report created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody @Valid ReportModel report){
        report.setId(id);
        ReportModel reportUpdate =  reportService.updateReport(report);

        return ResponseEntity.ok().header("Updated").body("Report updated");

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete report related with the id")
    public ResponseEntity<Void> deleteById(@PathVariable("id") int reportId) {
        return reportService.deleteById(reportId);
    }
}
