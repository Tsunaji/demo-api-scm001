package com.shera.api.scm001.dao.incoterm;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Incoterm {

    @Id
    private int incotermId;
    private String name;

    public int getIncotermId() {
        return incotermId;
    }

    public void setIncotermId(int incotermId) {
        this.incotermId = incotermId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Incoterm{" + "incotermId=" + incotermId + ", name=" + name + '}';
    }

}
