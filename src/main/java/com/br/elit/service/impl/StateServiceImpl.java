package com.br.elit.service.impl;

import com.br.elit.models.SensorModel;
import com.br.elit.models.StateModel;
import com.br.elit.repository.StateRepository;
import com.br.elit.service.StateService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.management.relation.RoleNotFoundException;
import javax.transaction.Transactional;
import java.util.Collections;
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
