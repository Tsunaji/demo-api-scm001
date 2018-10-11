package com.shera.api.scm001.dao.vehicle;

import com.shera.api.scm001.dao.vehicleStatus.VehicleStatus;
import java.util.Date;
import javax.persistence.CascadeType;
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
public class Vehicle {

    @Id
    @GeneratedValue
    private int vehicleId;
    private String referenceId;
    private String process;
    private String plant;
    private String product;
    private String company;
    private String transporterType;
    private String transporterCompany;
    private String transporterName;
    private String transporterPhone;
    private String vehicleType;
    private String license;
    private String incoterm;
    private String documentNumber;
    private double weightFromDocument;
    private String reasonNotInputWeight;
    private double weightIn;
    private double weightOut;
    private double weightNet;
    private int weightDifPercent;
    private String palleteNumber;
    private double weightPallete;
    private boolean isSpecialRelease;
    private String reasonSpecialRelease;
    private String shipment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicleStatusId")
    private VehicleStatus vehicleStatus;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @UpdateTimestamp
    @Temporal(TemporalType.DATE)
    private Date updatedDate;

    public Vehicle() {
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTransporterType() {
        return transporterType;
    }

    public void setTransporterType(String transporterType) {
        this.transporterType = transporterType;
    }

    public String getTransporterCompany() {
        return transporterCompany;
    }

    public void setTransporterCompany(String transporterCompany) {
        this.transporterCompany = transporterCompany;
    }

    public String getTransporterName() {
        return transporterName;
    }

    public void setTransporterName(String transporterName) {
        this.transporterName = transporterName;
    }

    public String getTransporterPhone() {
        return transporterPhone;
    }

    public void setTransporterPhone(String transporterPhone) {
        this.transporterPhone = transporterPhone;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getIncoterm() {
        return incoterm;
    }

    public void setIncoterm(String incoterm) {
        this.incoterm = incoterm;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public double getWeightFromDocument() {
        return weightFromDocument;
    }

    public void setWeightFromDocument(double weightFromDocument) {
        this.weightFromDocument = weightFromDocument;
    }

    public String getReasonNotInputWeight() {
        return reasonNotInputWeight;
    }

    public void setReasonNotInputWeight(String reasonNotInputWeight) {
        this.reasonNotInputWeight = reasonNotInputWeight;
    }

    public double getWeightIn() {
        return weightIn;
    }

    public void setWeightIn(double weightIn) {
        this.weightIn = weightIn;
    }

    public double getWeightOut() {
        return weightOut;
    }

    public void setWeightOut(double weightOut) {
        this.weightOut = weightOut;
    }

    public double getWeightNet() {
        return weightNet;
    }

    public void setWeightNet(double weightNet) {
        this.weightNet = weightNet;
    }

    public int getWeightDifPercent() {
        return weightDifPercent;
    }

    public void setWeightDifPercent(int weightDifPercent) {
        this.weightDifPercent = weightDifPercent;
    }

    public String getPalleteNumber() {
        return palleteNumber;
    }

    public void setPalleteNumber(String palleteNumber) {
        this.palleteNumber = palleteNumber;
    }

    public double getWeightPallete() {
        return weightPallete;
    }

    public void setWeightPallete(double weightPallete) {
        this.weightPallete = weightPallete;
    }

    public boolean isIsSpecialRelease() {
        return isSpecialRelease;
    }

    public void setIsSpecialRelease(boolean isSpecialRelease) {
        this.isSpecialRelease = isSpecialRelease;
    }

    public String getReasonSpecialRelease() {
        return reasonSpecialRelease;
    }

    public void setReasonSpecialRelease(String reasonSpecialRelease) {
        this.reasonSpecialRelease = reasonSpecialRelease;
    }

    public String getShipment() {
        return shipment;
    }

    public void setShipment(String shipment) {
        this.shipment = shipment;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
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
        return "Vehicle{" + "vehicleId=" + vehicleId + ", referenceId=" + referenceId + ", process=" + process + ", plant=" + plant + ", product=" + product + ", company=" + company + ", transporterType=" + transporterType + ", transporterCompany=" + transporterCompany + ", transporterName=" + transporterName + ", transporterPhone=" + transporterPhone + ", vehicleType=" + vehicleType + ", license=" + license + ", incoterm=" + incoterm + ", documentNumber=" + documentNumber + ", weightFromDocument=" + weightFromDocument + ", reasonNotInputWeight=" + reasonNotInputWeight + ", weightIn=" + weightIn + ", weightOut=" + weightOut + ", weightNet=" + weightNet + ", weightDifPercent=" + weightDifPercent + ", palleteNumber=" + palleteNumber + ", weightPallete=" + weightPallete + ", isSpecialRelease=" + isSpecialRelease + ", reasonSpecialRelease=" + reasonSpecialRelease + ", shipment=" + shipment + ", vehicleStatus=" + vehicleStatus.toString() + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + '}';
    }

}
