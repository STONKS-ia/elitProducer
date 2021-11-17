package com.br.elit.elitProducer.controller;

import com.br.elit.elitProducer.models.StateModel;
import com.br.elit.elitProducer.service.StateService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/state")
public class StateController {

    @Autowired
    public StateService stateService;

    @GetMapping
    @ApiOperation(value = "Return a list with all states")
    public ResponseEntity<List<StateModel>> getAll() {

        List<StateModel> states = stateService.getAll();

        return ResponseEntity.ok(states);

    }

    @PostMapping
    @ApiOperation(value = "Create a new state")
    public ResponseEntity create(@RequestBody @Valid StateModel stateModel) {

        StateModel state = stateService.createState(stateModel);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(stateModel.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update a state by ID")
    public ResponseEntity<String> update(@PathVariable("id") int id, @RequestBody @Valid StateModel stateModel){

        stateModel.setId(id);
        stateService.updateState(stateModel);

        return ResponseEntity.ok().header("Updated").body("State updated");

    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete the state")
    public ResponseEntity<Void> deleteById(@PathVariable("id") int stateId) {
        return stateService.deleteById(stateId);
    }

}
