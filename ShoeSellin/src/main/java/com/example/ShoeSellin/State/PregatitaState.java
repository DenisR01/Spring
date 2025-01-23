package com.example.ShoeSellin.State;

import com.example.ShoeSellin.Model.Order;

public class PregatitaState implements OrderState{
    @Override
    public String getState() {
        return "pregatita";
    }

    @Override
    public void handle(Order order) {
        order.setState(new PlatitaState().getState());
        order.notifyObservers();
    }
}
