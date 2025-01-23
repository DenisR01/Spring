package com.example.ShoeSellin.State;

import com.example.ShoeSellin.Model.Order;
import org.aspectj.weaver.ast.Or;

public class PlatitaState implements OrderState {
    @Override
    public String getState() {
        return "platita";
    }

    @Override
    public void handle(Order order) {
        order.setState(new PlasataState().getState());
        order.notifyObservers();
    }
}
