package com.br.elit.elitProducer.service;

import com.br.elit.elitProducer.models.SensorModel;
import com.br.elit.elitProducer.models.StateModel;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface StateService {

    List<StateModel> getAll();
    List<StateModel> getAllByFilter(int stateId, String name, String acronymState, String region);
    StateModel createState(StateModel state);
    StateModel updateState(StateModel state);
    Optional<StateModel> getById(int id);
    ResponseEntity<Void> deleteById(int id);

}