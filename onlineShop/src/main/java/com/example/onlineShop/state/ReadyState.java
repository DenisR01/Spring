package com.example.onlineShop.state;

import com.example.onlineShop.model.Order;

public class ReadyState implements OrderState{
    @Override
    public String getState() {
        return "ordered";
    }

    @Override
    public void handle(Order order) {
        order.setState(new DeliveredState().getState());
        order.notifyObservers();
    }
}
