package com.project.challenge.mobile.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Order implements Serializable {

    @SerializedName("order_id")
    private Long id;
    @SerializedName("submodel_name")
    private String submodelName;
    private List<StatusUse> statuses;

    public Order() {

    }

    public Order(Long id, String submodelName, List<StatusUse> statuses) {
        this.id = id;
        this.submodelName = submodelName;
        this.statuses = statuses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubmodelName() {
        return submodelName;
    }

    public void setSubmodelName(String submodelName) {
        this.submodelName = submodelName;
    }

    public List<StatusUse> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<StatusUse> statuses) {
        this.statuses = statuses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id.equals(order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", submodelName='" + submodelName + '\'' +
                ", statuses=" + statuses +
                '}';
    }
}
