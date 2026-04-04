package com.ecommerce.server_order.service;

import com.ecommerce.server_order.client.ProductClient;
import com.ecommerce.server_order.dto.ProductDTO;
import com.ecommerce.server_order.model.Order;
import com.ecommerce.server_order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductClient productClient;
    public List < Order > getAllOrders() {
        return orderRepository.findAll();
    }
    public Order createOrder(Long productId, Integer quantity) {

        ProductDTO product = productClient.getProductById(productId);
        Order order = new Order();
        order.setProductId(productId);
        order.setProductName(product.getName());
        order.setQuantity(quantity);
        order.setTotalPrice(product.getPrice() * quantity);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");
        return orderRepository.save(order);
    }
}
