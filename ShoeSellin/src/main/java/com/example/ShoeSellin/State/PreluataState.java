package com.example.ShoeSellin.State;

import com.example.ShoeSellin.Model.Order;

public class PreluataState implements OrderState{
    @Override
    public String getState() {
        return "preluata";
    }

    @Override
    public void handle(Order order) {
        order.setState(new PregatitaState().getState());
        order.notifyObservers();
    }
}
