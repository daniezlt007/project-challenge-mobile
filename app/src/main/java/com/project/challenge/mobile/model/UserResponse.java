package com.project.challenge.mobile.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserResponse implements Serializable {

    private boolean success;
    private String token;
    @SerializedName("avatar_url")
    private String avatarUrl;
    private String email;
    @SerializedName("username")
    private String userName;
    @SerializedName("fullname")
    private String fullName;
    private String city;
    @SerializedName("state_abbr")
    private String stateAbbr;

    public UserResponse() {
    }

    public UserResponse(boolean success, String token, String avatarUrl, String email, String userName, String fullName, String city, String stateAbbr) {
        this.success = success;
        this.token = token;
        this.avatarUrl = avatarUrl;
        this.email = email;
        this.userName = userName;
        this.fullName = fullName;
        this.city = city;
        this.stateAbbr = stateAbbr;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}
