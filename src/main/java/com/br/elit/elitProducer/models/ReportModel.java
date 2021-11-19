package com.br.elit.elitProducer.models;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "REPORTS")
public class ReportModel {

    @Id
    @Column(name = "REPORT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "REPORT_SEQUENCE")
    @SequenceGenerator(name = "REPORT_SEQUENCE", sequenceName = "REPORT_SEQ", allocationSize = 1)
    private int reportId;

    @Column(name = "CREATION_AT")
    private Date creationAt;

    @Column(name = "PH")
    @DecimalMin(value = "0.5", message = "The pH value must be higher than 0.5")
    @DecimalMax(value = "14", message = "The pH value must be lower than 14")
    private BigDecimal ph;

    @Column(name = "PH_STATUS")
    private String phStatus;

    @Column(name = "TEMPERATURE")
    private double temperature;

    @Column(name = "TURBIDITY")
    @DecimalMin(value = "1", message = "The turbidity must have at least 1 digit")
    private double turbidity;

    @Column(name = "TURBIDITY_STATUS")
    private String turbidityStatus;

    @Column(name = "ALKALINITY")
    @DecimalMin(value = "1", message = "The alkalinity value must have between 1-3 digits")
    private double alkalinity;

    @Column(name = "ALKALINITY_STATUS")
    private String alkalinityStatus;

    @Column(name = "CHLORIDES")
    @Size(min = 1, max = 1, message = "")
    private String chlorides;

    @Column(name = "COLIFORMS")
    @Size(min = 1, max = 10, message = "")
    private String coliforms;

    @ManyToOne
    @JoinColumn(name = "SENSOR_ID", nullable = false)
    private SensorModel sensor;

    public ReportModel(Date creationAt, BigDecimal ph, double temperature, double turbidity, double alkalinity, String chlorides, String coliforms, SensorModel sensor) {
        this.creationAt = creationAt;
        this.ph = ph;
        this.temperature = temperature;
        this.turbidity = turbidity;
        this.alkalinity = alkalinity;
        this.chlorides = chlorides;
        this.coliforms = coliforms;
        this.sensor = sensor;
    }

    public ReportModel() {
    }

    public int getId() {
        return reportId;
    }

    public void setId(int id) {
        this.reportId = id;
    }

    public Date getCreationAt() {
        return creationAt;
    }

    public void setCreationAt(Date creationAt) {
        this.creationAt = creationAt;
    }

    public BigDecimal getPh() {
        return ph;
    }

    public void setPh(BigDecimal ph) {
        this.ph = ph;
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

    public SensorModel getSensor() {
        return sensor;
    }

    public void setSensor(SensorModel sensor) {
        this.sensor = sensor;
    }

}
