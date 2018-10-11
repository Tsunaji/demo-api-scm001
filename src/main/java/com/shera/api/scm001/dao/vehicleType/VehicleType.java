package com.shera.api.scm001.dao.vehicleType;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class VehicleType {

    @Id
    private int vehicleTypeId;
    private String name;
    private double weightLimit;

    public int getVehicleTypeId() {
        return vehicleTypeId;
    }

    public void setVehicleTypeId(int vehicleTypeId) {
        this.vehicleTypeId = vehicleTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(double weightLimit) {
        this.weightLimit = weightLimit;
    }

    @Override
    public String toString() {
        return "VehicleType{" + "vehicleTypeId=" + vehicleTypeId + ", name=" + name + ", weightLimit=" + weightLimit + '}';
    }

}
