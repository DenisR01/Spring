package com.example.Vet.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Schimbat din String în Long
    private String name;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VetRequest> emplVetRequests;

    // Constructors, getters, and setters
    public Employee() {}

    public Employee(Long id, String name, List<VetRequest> emplVetRequests) {
        this.id = id;
        this.name = name;
        this.emplVetRequests = emplVetRequests;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<VetRequest> getEmplVetRequests() {
        return emplVetRequests;
    }

    public void setEmplVetRequests(List<VetRequest> emplVetRequests) {
        this.emplVetRequests = emplVetRequests;
    }
}
