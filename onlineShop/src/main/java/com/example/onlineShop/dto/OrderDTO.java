package com.example.onlineShop.dto;

import com.example.onlineShop.model.Client;
import com.example.onlineShop.model.Product;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;

import java.util.List;

public class OrderDTO {

    private Long id;
    private String state;
    private List<String> orderedProducts;
    private Long client;

    public OrderDTO(Long id, String state, List<String> orderedProducts, Long client) {
        this.id = id;
        this.state = state;
        this.orderedProducts = orderedProducts;
        this.client = client;
    }

    public OrderDTO() {
    }

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

    public Long getClient() {
        return client;
    }

    public void setClient(Long client) {
        this.client = client;
    }

}
