package com.shera.api.scm001.dao.status;

import com.shera.api.scm001.dao.plant.Plant;
import com.shera.api.scm001.dao.process.Process;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Status {

    @Id
    @GeneratedValue
    private int statusId;
    @ManyToOne
    @JoinColumn(name = "processId")
    private Process process;
    @ManyToOne
    @JoinColumn(name = "plantId")
    private Plant plant;
    private String name;
    private int duration;
    private int sequence;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    @Override
    public String toString() {
        return "Status{" + "statusId=" + statusId + ", process=" + process + ", plant=" + plant + ", name=" + name + ", duration=" + duration + ", sequence=" + sequence + '}';
    }
}
