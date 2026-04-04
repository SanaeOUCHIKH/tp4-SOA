package com.ecommerce.server_order.controller;

import com.ecommerce.server_order.model.Order;
import com.ecommerce.server_order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @GetMapping public List < Order > getAllOrders() {
        return orderService.getAllOrders();
    }
    @PostMapping public Order createOrder(@RequestParam Long productId, @RequestParam Integer quantity) {
        return orderService.createOrder(productId, quantity);
    }
}
