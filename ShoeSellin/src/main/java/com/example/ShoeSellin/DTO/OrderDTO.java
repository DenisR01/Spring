package com.example.ShoeSellin.DTO;

import com.example.ShoeSellin.Model.Client;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

import java.util.List;

public class OrderDTO {

    private Long id;
    private String state;
    private List<String> orderedProducts;
    private String Client;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<String> getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(List<String> orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public String getClient() {
        return Client;
    }

    public void setClient(String client) {
        Client = client;
    }

    public OrderDTO() {
    }

    public OrderDTO(Long id, String state, List<String> orderedProducts, String client) {
        this.id = id;
        this.state = state;
        this.orderedProducts = orderedProducts;
        Client = client;
    }
}
