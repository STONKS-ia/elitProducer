package com.br.elit.elitProducer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "STATES")
public class StateModel {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATE_SEQUENCE")
    @SequenceGenerator(name = "STATE_SEQUENCE", sequenceName = "STATE_SEQ", allocationSize = 1)
    private int id;

    @Column
    @NotNull(message = "The name of the state is mandatory")
    @Size(min = 1, max = 30, message = "The state's name must have between 1-30 characters")
    private String name;

    @Column
    @NotNull(message = "The state's acronym is mandatory")
    @Size(min = 2, max = 2, message = "The state's acronym must have 2 characters")
    private String acronymState;

    @Column
    @Size(min = 3, max = 20, message = "The state's region must have between 3-20 characters")
    private String region;

    public StateModel(String name, String acronymState, String region) {
        this.name = name;
        this.acronymState = acronymState;
        this.region = region;
    }

    public StateModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAcronymState() {
        return acronymState;
    }

    public void setAcronymState(String acronymState) {
        this.acronymState = acronymState;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

}