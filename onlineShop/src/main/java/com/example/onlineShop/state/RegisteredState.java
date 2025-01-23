package com.example.onlineShop.state;

import com.example.onlineShop.model.Order;

public class RegisteredState implements OrderState{
    @Override
    public String getState() {
        return "registered";
    }

    @Override
    public void handle(Order order) {
        order.setState(new RegisteredState().getState());
        order.notifyObservers();
    }
}
