package com.br.elit.elitProducer.controller;

import com.br.elit.elitProducer.models.ReportModel;
import com.br.elit.elitProducer.models.SensorModel;
import com.br.elit.elitProducer.models.StateModel;
import com.br.elit.elitProducer.service.SensorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    @Autowired
    public SensorService sensorService;

    @GetMapping
    @ApiOperation(value = "Return a list with all sensors")
    public ResponseEntity<List<SensorModel>> getAll() {

        List<SensorModel> sensor = sensorService.getAll();

        return ResponseEntity.ok(sensor);
    }

    @GetMapping("/filter")
    @ApiOperation(value = "Return a filtered list with all sensors")
    public ResponseEntity<List<SensorModel>> getAllByFilter(@RequestParam int sensorId,@RequestParam  String material,@RequestParam  String serialNumber,@RequestParam  String manufacturer) {

        List<SensorModel> sensor = sensorService.getAllByFilter(sensorId, material, serialNumber, manufacturer);

        return ResponseEntity.ok(sensor);
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Return a sensor by id")
    public ResponseEntity<Optional<SensorModel>> findById(@PathVariable("id") int id) {

        Optional<SensorModel> state = sensorService.getById(id);

        return ResponseEntity.ok(state);
    }

    @PostMapping()
    public ResponseEntity<String> save(@RequestBody @Valid SensorModel sensor) {

        sensorService.createSensor(sensor);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(sensor.getSensorId()).toUri();

        return ResponseEntity.created(location).header("Created").body("Sensor created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody @Valid SensorModel sensor){

        sensor.setSensorId(id);
        sensorService.updateSensor(sensor);

        return ResponseEntity.ok().header("Updated").body("Sensor updated");

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete sensor related with the id")
    public ResponseEntity<Void> deleteById(@PathVariable("id") int id) {
        return sensorService.deleteSensor(id);
    }
}