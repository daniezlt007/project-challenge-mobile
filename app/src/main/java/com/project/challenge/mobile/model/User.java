package com.project.challenge.mobile.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class User implements Serializable {

    private boolean success;
    @SerializedName("avatar_url")
    private String avatarUrl;
    @SerializedName("username")
    private String userName;
    @SerializedName("fullname")
    private String fullName;
    private String city;
    @SerializedName("state_abbr")
    private String stateAbbr;
    private List<Order> orders;

    public User() {

    }

    public User(boolean success, String avatarUrl, String userName, String fullName, String city, String stateAbbr, List<Order> orders) {
        this.success = success;
        this.avatarUrl = avatarUrl;
        this.userName = userName;
        this.fullName = fullName;
        this.city = city;
        this.stateAbbr = stateAbbr;
        this.orders = orders;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateAbbr() {
        return stateAbbr;
    }

    public void setStateAbbr(String stateAbbr) {
        this.stateAbbr = stateAbbr;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(fullName, user.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, fullName);
    }

    @Override
    public String toString() {
        return "User{" +
                "success=" + success +
                ", avatarUrl='" + avatarUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", city='" + city + '\'' +
                ", stateAbbr='" + stateAbbr + '\'' +
                ", orders=" + orders +
                '}';
    }
}
