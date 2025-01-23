package com.example.ShoeSellin.State;

import com.example.ShoeSellin.Model.Order;

public interface OrderState {
    String getState();
    void  handle(Order order);
}
