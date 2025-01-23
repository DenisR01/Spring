package com.example.ShoeSellin.Controller;

import com.example.ShoeSellin.Model.Order;
import com.example.ShoeSellin.Service.OrderService;
import com.example.ShoeSellin.State.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public  String getAllOrders(Model model){
        var orders= orderService.getAllOrders();
        model.addAttribute("orders",orders);
        return "orders";
    }

    @GetMapping("/{id}/update")
    public String showUpdateOrderStateForm(@PathVariable Long id, Model model) {
        Order order = orderService.findById(id); // Găsește comanda (returnează direct Order, nu Optional)// Exemplu de gestionare a erorilor

        model.addAttribute("order", order); // Adaugă comanda în model
        return "updateOrderState.html"; //
    }

    @PostMapping("/{id}/state")
    public String updateOrderState(@PathVariable Long id, @RequestParam String newState, RedirectAttributes redirectAttributes){
        var order = orderService.findById(id);
        OrderState stateToSet = switch (newState.toLowerCase()) {
            case "plasata" -> new PlasataState();
            case "platita" -> new PlatitaState();
            case "pregatita" -> new PregatitaState();
            case "preluata" -> new PreluataState();
            default -> throw new IllegalArgumentException("Starea specificată nu este validă: " + newState);
        };
        orderService.updateState(order.getId(),stateToSet);

        redirectAttributes.addFlashAttribute("succes",true);
        return "redirect:/orders";
    }
}
