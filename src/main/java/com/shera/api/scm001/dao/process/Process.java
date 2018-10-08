package com.shera.api.scm001.dao.process;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Process {

    @Id
    private String processId;
    private String name;

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Process{" + "processId=" + processId + ", name=" + name + '}';
    }

}
