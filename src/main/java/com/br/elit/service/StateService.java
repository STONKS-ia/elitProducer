package com.br.elit.service;

import com.br.elit.models.StateModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StateService {

    List<StateModel> getAll();
    StateModel createState(StateModel state);
    StateModel updateState(StateModel state);
    Optional<StateModel> getById(int id);
    ResponseEntity<Void> deleteById(int id);



}
