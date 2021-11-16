package com.br.elit.service.impl;

import com.br.elit.models.ReportModel;
import com.br.elit.models.SensorModel;
import com.br.elit.repository.ReportRepository;
import com.br.elit.repository.SensorRepository;
import com.br.elit.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SensorService")
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Override
    public List<SensorModel> getAll() {
        return sensorRepository.findAll();
    }

    @Override
    public SensorModel createSensor(SensorModel sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public SensorModel updateSensor(SensorModel sensor) {
        return sensorRepository.save(sensor);
    }

    @Override
    public ResponseEntity<Void> deleteSensor(int sensorId) {
        sensorRepository.deleteById(sensorId);
        return null;
    }

}