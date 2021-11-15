package com.br.elit.models;

import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SENSORS")
public class SensorModel {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SENSOR_SEQUENCE")
    @SequenceGenerator(name = "SENSOR_SEQUENCE", sequenceName = "SENSOR_SEQ", allocationSize = 1)
    private int id;

    @Column
    @NotNull(message = "The is mandatory")
    private boolean isActivated;

    @Column
    @NotNull(message = "The sensor's serial number is mandatory")
    private String serialNumber;

    @Column
    @Size(min = 1, max = 30, message = "The material must have between 1 and 30 characters")
    private String material;

    @Column
    @Size(min = 1, max = 30, message = "The manufacturer name must have between 1 and 30 characters")
    private String manufacturer;

    public SensorModel(String serialNumber, String material, String manufacturer) {
        this.serialNumber = serialNumber;
        this.material = material;
        this.manufacturer = manufacturer;
    }

    public SensorModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

}