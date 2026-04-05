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

        // Si le produit est null (n'existe pas dans l'autre service)
        if (product == null) {
            throw new RuntimeException("Erreur : Le produit avec l'ID " + productId + " n'existe pas !");
        }

        // 1. Vérification basique du stock avant création
        if (product.getStock() < quantity) {
            throw new RuntimeException("Impossible de commander : stock insuffisant");
        }

        Order order = new Order();
        order.setProductId(productId);
        order.setProductName(product.getName());
        order.setQuantity(quantity);
        order.setTotalPrice(product.getPrice() * quantity);
        order.setOrderDate(LocalDateTime.now());
        order.setStatus("PENDING");

        Order savedOrder = orderRepository.save(order);
        // 2. Appel au Product Service pour mettre à jour le stock réel
        productClient.updateProductStock(productId, quantity);

        return savedOrder;
    }
}
