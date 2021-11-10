package com.br.elit.models;

import javax.persistence.*;

@Entity
@Table(name = "STATES")
public class StateModel {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STATE_SEQUENCE")
    @SequenceGenerator(name = "STATE_SEQUENCE", sequenceName = "STATE_SEQ", allocationSize = 1)
    private int id;

    @Column
    private String name;

    @Column
    private String acronymState;

    @Column
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