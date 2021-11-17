package com.br.elit.elitProducer.repository;

import com.br.elit.elitProducer.models.StateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<StateModel, Integer> {


}
