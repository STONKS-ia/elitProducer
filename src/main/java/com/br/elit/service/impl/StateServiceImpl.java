package com.br.elit.service.impl;

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
@Transactional
public class StateServiceImpl implements StateService {

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private StateRepository stateRepository;

    public ResponseEntity<StateModel> createState(StateModel state) {

        logger.info(String.format("Saving new state: %s on database", state.getName()));

        stateRepository.save(state);

        return ResponseEntity.created(null).body(stateRepository.save(state));
    }

    public List<StateModel> getAll() {
        return stateRepository.findAll();
    }

    public Optional<StateModel> getById(int id) {
        
        return stateRepository.findById(id);

    }

//    public List<StateModel> updateState(StateModel state) {
//
//        Optional<StateModel> optState  = stateRepository.findById(state.getId());
//
//
//
//
//        int id = stateRepository. findById(state.getId());
//
//    }






}
