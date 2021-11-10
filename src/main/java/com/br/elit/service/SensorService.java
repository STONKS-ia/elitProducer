package com.br.elit.service;

import com.br.elit.models.SensorModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SensorService {
    ResponseEntity<SensorModel> createSensor(SensorModel sensor);
    List<SensorModel> getAll();
    ResponseEntity<Void> deleteSensor(String sensorId);



}
