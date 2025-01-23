package com.example.Vet.DTO;

public class vetReqRequestDTO {
    private Long clientId;
    private Long employeeId;
    private String location;
    private String descriere;

    public vetReqRequestDTO() {
    }

    public vetReqRequestDTO(Long clientId, Long employeeId, String location, String descriere) {
        this.clientId = clientId;
        this.employeeId = employeeId;
        this.location = location;
        this.descriere = descriere;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

}
