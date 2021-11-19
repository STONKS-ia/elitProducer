package com.br.elit.elitProducer.service.impl;

import com.br.elit.elitProducer.models.SensorModel;
import com.br.elit.elitProducer.models.StateModel;
import com.br.elit.elitProducer.repository.StateRepository;
import com.br.elit.elitProducer.service.StateService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("StateService")
public class StateServiceImpl implements StateService {

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<StateModel> getAll() {
        return stateRepository.findAll();
    }

    @Override
    public List<StateModel> getAllByFilter(int stateId, String name, String acronymState, String region) {
        if(name.isEmpty())
            name = null;
        if(acronymState.isEmpty())
            acronymState = null;
        if(region.isEmpty())
            region = null;

        return stateRepository.findAllFilter(stateId, name, acronymState, region);
    }
    @Override
    public Optional<StateModel> getById(int id) {
        return stateRepository.findById(id);
    }

    @Override
    public StateModel createState(StateModel state) {
        return stateRepository.save(state);
    }

    @Override
    public StateModel updateState(StateModel state) {
        return stateRepository.save(state);
    }

    @Override
    public ResponseEntity<Void> deleteById(int stateId) {
        stateRepository.deleteById(stateId);
        return null;
    }
}
