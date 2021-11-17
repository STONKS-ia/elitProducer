package com.br.elit.elitProducer.controller;

import com.br.elit.elitProducer.models.SensorModel;
import com.br.elit.elitProducer.service.SensorService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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

    @PostMapping()
    public ResponseEntity<String> save(@RequestBody @Valid SensorModel sensor) {

        sensorService.createSensor(sensor);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(sensor.getId()).toUri();

        return ResponseEntity.created(location).header("Created").body("Sensor created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody @Valid SensorModel sensor){

        sensor.setId(id);
        sensorService.updateSensor(sensor);

        return ResponseEntity.ok().header("Updated").body("Sensor updated");

    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete sensor related with the id")
    public ResponseEntity<Void> deleteById(@PathVariable("id") int id) {
        return sensorService.deleteSensor(id);
    }
}