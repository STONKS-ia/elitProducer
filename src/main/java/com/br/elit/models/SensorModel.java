package com.br.elit.models;

import javax.persistence.*;

@Entity
@Table(name = "SENSORS")
public class SensorModel {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SENSOR_SEQUENCE")
    @SequenceGenerator(name = "SENSOR_SEQUENCE", sequenceName = "SENSOR_SEQ", allocationSize = 1)
    private int id;

    @Column
    private String serialNumber;

    @Column
    private String material;

    @Column
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