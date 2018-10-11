package com.shera.api.scm001.dao.plant;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Plant {

    @Id
    private String plantId;
    private String name;
    private String address;

    public String getPlantId() {
        return plantId;
    }

    public void setPlantId(String plantId) {
        this.plantId = plantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Plant{" + "plantId=" + plantId + ", name=" + name + ", address=" + address + '}';
    }

}
