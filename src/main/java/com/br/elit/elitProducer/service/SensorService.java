package com.br.elit.elitProducer.service;

import com.br.elit.elitProducer.models.ReportModel;
import com.br.elit.elitProducer.models.SensorModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface SensorService {

    List<SensorModel> getAll();
    List<SensorModel> getAllByFilter(int sensorId,String material,String serialNumber,String manufacturer);
    Optional<SensorModel> getById(int sensorId);
    SensorModel createSensor(SensorModel sensor);
    SensorModel updateSensor(SensorModel sensor);
    ResponseEntity<Void> deleteSensor(int sensorId);

}
