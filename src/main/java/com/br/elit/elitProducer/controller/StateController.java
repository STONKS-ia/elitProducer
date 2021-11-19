package com.br.elit.elitProducer.controller;

import com.br.elit.elitProducer.exception.ApiBussinessException;
import com.br.elit.elitProducer.models.ReportModel;
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
import java.util.Optional;

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
    @GetMapping
    @ApiOperation(value = "Return a filtered list with all states")
    public ResponseEntity<List<StateModel>> getAllByFilter(@RequestParam int stateId, @RequestParam String name,@RequestParam String acronymState,@RequestParam String region) {

        List<StateModel> state = stateService.getAllByFilter(stateId, name, acronymState, region);

        return ResponseEntity.ok(state);
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Return a state by id")
    public ResponseEntity<Optional<StateModel>> findById(@PathVariable("id") int id) {

        Optional<StateModel> state = stateService.getById(id);

        return ResponseEntity.ok(state);
    }

    @PostMapping
    @ApiOperation(value = "Create a new state")
    public ResponseEntity create(@RequestBody @Valid StateModel stateModel) throws ApiBussinessException {

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
