package com.br.elit.elitProducer.service;

import com.br.elit.elitProducer.models.ReportModel;
import com.br.elit.elitProducer.models.SensorModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SensorService {

    List<SensorModel> getAll();
    SensorModel getById(int sensorId);
    SensorModel createSensor(SensorModel sensor);
    SensorModel updateSensor(SensorModel sensor);
    ResponseEntity<Void> deleteSensor(int sensorId);

}
