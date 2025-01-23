package com.example.ShoeSellin.Observer;

import com.example.ShoeSellin.Model.Order;

public class ClientObserver implements Observer{
    @Override
    public void update(Order order) {
        System.out.println("Comanda cu ID: " + order.getId() + " a trecut la starea: " + order.getState());
    }
}
