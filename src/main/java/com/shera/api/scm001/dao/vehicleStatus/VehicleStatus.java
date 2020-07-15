package com.shera.api.scm001.dao.vehicleStatus;

import com.shera.api.scm001.dao.status.Status;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class VehicleStatus {

    @Id
    @GeneratedValue
    private int vehicleStatusId;
    private int vehicleId;
    @OneToOne
    @JoinColumn(name = "statusId")
    private Status status;
    @Temporal(TemporalType.TIMESTAMP)
    private Date estimateTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualTime;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;

    public VehicleStatus() {
    }

    public int getVehicleStatusId() {
        return vehicleStatusId;
    }

    public void setVehicleStatusId(int vehicleStatusId) {
        this.vehicleStatusId = vehicleStatusId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getEstimateTime() {
        return estimateTime;
    }

    public void setEstimateTime(Date estimateTime) {
        this.estimateTime = estimateTime;
    }

    public Date getActualTime() {
        return actualTime;
    }

    public void setActualTime(Date actualTime) {
        this.actualTime = actualTime;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    @Override
    public String toString() {
        return "VehicleStatus{" + "vehicleStatusId=" + vehicleStatusId + ", vehicleId=" + vehicleId + ", status=" + status.toString() + ", estimateTime=" + estimateTime + ", actualTime=" + actualTime + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + '}';
    }

}
