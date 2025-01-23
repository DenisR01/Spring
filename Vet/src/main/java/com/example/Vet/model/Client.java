package com.example.Vet.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nume;

    @OneToMany(mappedBy = "client",cascade = CascadeType.ALL,orphanRemoval = true)
    List<VetRequest> clientVetRequests;

    public Client(Long id, String nume, List<VetRequest> vetRequests) {
        this.id = id;
        this.nume = nume;
        this.clientVetRequests = vetRequests;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public List<VetRequest> getClientVetRequests() {
        return clientVetRequests;
    }

    public void setClientVetRequests(List<VetRequest> clientVetRequests) {
        this.clientVetRequests = clientVetRequests;
    }

    public Client() {
    }
}
