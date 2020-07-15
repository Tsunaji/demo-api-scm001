package com.shera.api.scm001.dao.product;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private int productId;
    private String name;
    private int weightDifMin;
    private int weightDifMax;

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeightDifMin() {
        return weightDifMin;
    }

    public void setWeightDifMin(int weightDifMin) {
        this.weightDifMin = weightDifMin;
    }

    public int getWeightDifMax() {
        return weightDifMax;
    }

    public void setWeightDifMax(int weightDifMax) {
        this.weightDifMax = weightDifMax;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", name=" + name + ", weightDifMin=" + weightDifMin + ", weightDifMax=" + weightDifMax + '}';
    }

}
