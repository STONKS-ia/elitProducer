package com.br.elit.service;

import com.br.elit.models.StateModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StateService {

    ResponseEntity<StateModel> createState(StateModel state);
    List<StateModel> getAll();
    Optional<StateModel> getById(int id);
//    ResponseEntity<StateModel> updateState(StateModel state);
//    ResponseEntity<Void> deleteState(String name);



}
