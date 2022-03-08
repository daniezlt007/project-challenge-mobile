package com.project.challenge.mobile.model;

import java.io.Serializable;

public class StatusUse implements Serializable {

    private String code;
    private String label;
    private Boolean checked;

    public StatusUse() {

    }

    public StatusUse(String code, String label, Boolean checked) {
        this.code = code;
        this.label = label;
        this.checked = checked;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    @Override
    public String toString() {
        return "StatusUse{" +
                "code='" + code + '\'' +
                ", label='" + label + '\'' +
                ", checked=" + checked +
                '}';
    }
}
