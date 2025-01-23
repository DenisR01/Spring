package com.example.onlineShop.observer;

import com.example.onlineShop.model.Order;

public interface Observer {
    void update(Order order);
}
