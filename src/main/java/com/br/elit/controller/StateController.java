package com.br.elit.controller;

import com.br.elit.models.StateModel;
import com.br.elit.service.StateService;
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

    @PostMapping
    @ApiOperation(value = "Cria um novo estado")
    public ResponseEntity create(@RequestBody @Valid StateModel stateModel) {

        ResponseEntity<StateModel> state = stateService.createState(stateModel);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(state.getBody().getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping
    @ApiOperation(value = "Retorna uma lista de todos os estados")
    public ResponseEntity<List<StateModel>> getAll() {

        List<StateModel> states = stateService.getAll();

        return ResponseEntity.ok(states);

    }




}
