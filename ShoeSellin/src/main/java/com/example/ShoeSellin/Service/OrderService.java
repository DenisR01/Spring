package com.example.ShoeSellin.Service;

import com.example.ShoeSellin.DTO.OrderDTO;
import com.example.ShoeSellin.Model.Order;
import com.example.ShoeSellin.Model.Product;
import com.example.ShoeSellin.Repository.ClientRepository;
import com.example.ShoeSellin.Repository.OrderRepository;
import com.example.ShoeSellin.State.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private  final ClientRepository clientRepository;

    public OrderService(OrderRepository orderRepository, ClientRepository clientRepository) {
        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
    }

    public Order findById(Long id){
        return orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("order not found"));
    }

    public List<OrderDTO> getAllOrders(){
        var orders= orderRepository.findAll();
        if(orders.isEmpty())
            return new ArrayList<>();

        return orders.stream().map(this::toOrderDTO).toList();
    }

    public  OrderDTO toOrderDTO(Order order){
        return new OrderDTO(order.getId(),order.getState(),order.getProducts().stream().map(Product::getName).toList(),order.getClient().getName());
    }

//    public OrderDTO updateState(Long orderId, OrderState orderState){
//        var order=orderRepository.findById(orderId).orElseThrow(()->new IllegalArgumentException("Order not found"));
//        orderState.handle(order);
//        order.notifyObservers();
//        return toOrderDTO(orderRepository.save(order));
//    }
    public void updateState(Long orderId, OrderState orderState){
        var order=orderRepository.findById(orderId).orElseThrow(()->new IllegalArgumentException("Order not found"));
        orderState.handle(order);
        order.notifyObservers();
        orderRepository.save(order);
    }


}
