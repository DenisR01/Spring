package com.example.Vet.DTO;

import com.example.Vet.model.Client;
import com.example.Vet.model.Employee;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

public class VetReqDTO {
    private Long id;
    private String location;
    private String descriere;
    private String state;
    private String client;
    private String employee;

    public VetReqDTO(Long id, String location, String descriere, String state, String client, String employee) {
        this.id = id;
        this.location = location;
        this.descriere = descriere;
        this.state = state;
        this.client = client;
        this.employee = employee;
    }

    public VetReqDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }
}
