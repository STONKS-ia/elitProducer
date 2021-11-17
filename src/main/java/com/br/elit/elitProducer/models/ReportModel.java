package com.br.elit.elitProducer.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "REPORTS")
public class ReportModel {

    @Id
    @Column(name = "REPORT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORT_SEQUENCE")
    @SequenceGenerator(name = "REPORT_SEQUENCE", sequenceName = "REPORT_SEQ", allocationSize = 1)
    private int id;

    @Column(name = "CREATION_AT")
    @NotNull(message = "The creation date is mandatory")
    private Date creationAt;

    @Column(name = "PH")
    @Size(min = 1, max = 2, message = "The pH value must have 2 digits")
    private double ph;

    @Column(name = "PH_STATUS")
    private String phStatus;

    @Column(name = "TEMPERATURE")
    @Size(min = 1, max = 4, message = "The temperature must respect the following standard: '21.4'")
    private double temperature;

    @Column(name = "TURBIDITY")
    @Size(min = 1, max = 1, message = "The turbidity must have at least 1 digit")
    private double turbidity;

    @Column(name = "TURBIDITY_STATUS")
    private String turbidityStatus;

    @Column(name = "ALKALINITY")
    @Size(min = 1, max = 3, message = "The alkalinity value must have between 1-3 digits")
    private double alkalinity;

    @Column(name = "ALKALINITY_STATUS")
    private String alkalinityStatus;

    @Column(name = "CHLORIDES")
    @Size(min = 1, max = 1, message = "")
    private String chlorides;

    @Column(name = "COLIFORMS")
    @Size(min = 1, max = 1, message = "")
    private String coliforms;

    @Column(name = "SEAWEED")
    @Size(min = 1, max = 1, message = "")
    private String seaweed;

    @ManyToOne
    @JoinColumn(name = "SENSOR_ID")
    @NotNull(message = "The sensor related to this report is mandatory")
    private SensorModel sensor;

    public ReportModel(Date creationAt, double ph, double temperature, double turbidity, double alkalinity, String chlorides, String coliforms, String seaweed, SensorModel sensor) {
        this.creationAt = creationAt;
        this.ph = ph;
        this.temperature = temperature;
        this.turbidity = turbidity;
        this.alkalinity = alkalinity;
        this.chlorides = chlorides;
        this.coliforms = coliforms;
        this.seaweed = seaweed;
        this.sensor = sensor;
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

    public double getPh() {
        return ph;
    }

    public void setPh(double temperature) {
        this.temperature = ph;
    }

    public String getPhStatus(){
        return phStatus;
    }

    public void setPhStatus(String phStatus){
        this.phStatus = phStatus;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getTurbidity() {
        return turbidity;
    }

    public void setTurbidity(double turbidity) {
        this.turbidity = turbidity;
    }

    public double getAlkalinity() {
        return alkalinity;
    }

    public void setAlkalinity(double alkalinity) {
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

    public String getTurbidityStatus() {
        return turbidityStatus;
    }

    public void setTurbidityStatus(String turbidityStatus) {
        this.turbidityStatus= turbidityStatus;
    }
    public String getAlkalinityStatus(){return alkalinityStatus;}

    public void setAlkalinityStatus(String alkalinityStatus){
        this.alkalinityStatus = alkalinityStatus;
    }
}
