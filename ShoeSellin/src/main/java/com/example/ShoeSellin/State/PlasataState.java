package com.example.ShoeSellin.State;

import com.example.ShoeSellin.Model.Order;

public class PlasataState implements OrderState{
    @Override
    public String getState() {
        return "plasata";
    }

    @Override
    public void handle(Order order) {
    }
}
