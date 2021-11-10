package com.br.elit.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "REPORTS")
public class ReportModel {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORT_SEQUENCE")
    @SequenceGenerator(name = "REPORT_SEQUENCE", sequenceName = "REPORT_SEQ", allocationSize = 1)
    private int id;

    @Column
    private Date creationAt;

    @Column
    private String temperature;

    @Column
    private String turbidity;

    @Column
    private String alkalinity;

    @Column
    private String chlorides;

    @Column
    private String coliforms;

    @Column
    private String seaweed;

    public ReportModel(Date creationAt, String temperature, String turbidity, String alkalinity, String chlorides, String coliforms, String seaweed) {
        this.creationAt = creationAt;
        this.temperature = temperature;
        this.turbidity = turbidity;
        this.alkalinity = alkalinity;
        this.chlorides = chlorides;
        this.coliforms = coliforms;
        this.seaweed = seaweed;
    }

    public ReportModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreationAt() {
        return creationAt;
    }

    public void setCreationAt(Date creationAt) {
        this.creationAt = creationAt;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(String turbidity) {
        this.turbidity = turbidity;
    }

    public String getAlkalinity() {
        return alkalinity;
    }

    public void setAlkalinity(String alkalinity) {
        this.alkalinity = alkalinity;
    }

    public String getChlorides() {
        return chlorides;
    }

    public void setChlorides(String chlorides) {
        this.chlorides = chlorides;
    }

    public String getColiforms() {
        return coliforms;
    }

    public void setColiforms(String coliforms) {
        this.coliforms = coliforms;
    }

    public String getSeaweed() {
        return seaweed;
    }

    public void setSeaweed(String seaweed) {
        this.seaweed = seaweed;
    }
}
