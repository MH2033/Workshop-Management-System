package com.project.workshopmanagment.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class ContactPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String data;

    @NotBlank
    private String type;

    public ContactPoint() {
    }

    public ContactPoint(String data, String type) {
        this.data = data;
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
