package com.example.onlineShop.state;

import com.example.onlineShop.model.Order;

public interface OrderState {
    String getState();
    void handle(Order order);
}
