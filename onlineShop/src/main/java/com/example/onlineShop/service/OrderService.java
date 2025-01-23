package com.example.onlineShop.service;

import com.example.onlineShop.dto.OrderDTO;
import com.example.onlineShop.model.Order;
import com.example.onlineShop.model.Product;
import com.example.onlineShop.repository.OrderRepository;
import com.example.onlineShop.state.OrderState;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order findById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found")); // Aruncă excepție dacă nu găsește
    }

    public List<OrderDTO> getAll(){
        var orders =  orderRepository.findAll();
        if(orders.isEmpty())
            return new ArrayList<>();

        return orders.stream().map(this::toOrderDTO).toList();
    }

    public void updateOrderState(Long orderId, OrderState newState) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        newState.handle(order);
        orderRepository.save(order); // Persistă modificările
        order.notifyObservers(); //
    }

    public OrderDTO toOrderDTO(Order order){
        return new OrderDTO(order.getId(),order.getState(),order.getOrderedProducts().stream().map(Product::getName).toList(),order.getClient().getId());
    }
}
