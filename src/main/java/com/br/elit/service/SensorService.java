package com.br.elit.service;

import com.br.elit.models.SensorModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SensorService {

    List<SensorModel> getAll();
    SensorModel createSensor(SensorModel sensor);
    SensorModel updateSensor(SensorModel sensor);
    ResponseEntity<Void> deleteSensor(int sensorId);

}
