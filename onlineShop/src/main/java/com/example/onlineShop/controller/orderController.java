package com.example.onlineShop.controller;

import com.example.onlineShop.dto.OrderDTO;
import com.example.onlineShop.model.Order;
import com.example.onlineShop.service.OrderService;
import com.example.onlineShop.state.DeliveredState;
import com.example.onlineShop.state.OrderState;
import com.example.onlineShop.state.ReadyState;
import com.example.onlineShop.state.RegisteredState;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class orderController {
    private final OrderService orderService;

    public orderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public String getAllOrders(Model model) {
        List<OrderDTO> orders = orderService.getAll();
        model.addAttribute("orders", orders);
        return "orders"; // numele paginii Thymeleaf
    }
//    @PutMapping("/{id}/state")
//    public String updateOrderState(@PathVariable Long id, @RequestParam String newState, RedirectAttributes redirectAttributes) {
//        Optional<Order> order = orderService.findById(id); // Găsește comanda
//
//        // Aici alegi starea nouă în funcție de input-ul primit
//        OrderState stateToSet;
//        switch (newState.toLowerCase()) {
//            case "registered":
//                stateToSet = new RegisteredState();
//                break;
//            case "ready":
//                stateToSet = new ReadyState();
//                break;
//            case "delivered":
//                stateToSet = new DeliveredState();
//                break;
//            default:
//                throw new IllegalArgumentException("Starea specificată nu este validă: " + newState);
//        }
//
//        orderService.updateOrderState(id, stateToSet); // Actualizează starea
//
//        redirectAttributes.addFlashAttribute("success", true); // Adaugă mesaj de succes
//
//        return "redirect:/orders"; // Redirecționează la lista comenzilor
//    }
@PostMapping("/{id}/state")
public String updateOrderState(@PathVariable Long id, @RequestParam String newState, RedirectAttributes redirectAttributes) {
    Order order = orderService.findById(id); // Găsește comanda (returnează direct Order, nu Optional)

    // Aici alegi starea nouă în funcție de input-ul primit
    OrderState stateToSet;
    switch (newState.toLowerCase()) {
        case "registered":
            stateToSet = new RegisteredState();
            break;
        case "ready":
            stateToSet = new ReadyState();
            break;
        case "delivered":
            stateToSet = new DeliveredState();
            break;
        default:
            throw new IllegalArgumentException("Starea specificată nu este validă: " + newState);
    }

    orderService.updateOrderState(order.getId(), stateToSet); // Actualizează starea

    redirectAttributes.addFlashAttribute("success", true); // Adaugă mesaj de succes

    return "redirect:/orders"; // Redirecționează la lista comenzilor
}

    @GetMapping("/{id}/update")
    public String showUpdateOrderStateForm(@PathVariable Long id, Model model) {
        Order order = orderService.findById(id); // Găsește comanda (returnează direct Order, nu Optional)// Exemplu de gestionare a erorilor

        model.addAttribute("order", order); // Adaugă comanda în model
        return "updateOrderState"; //
    }
}
