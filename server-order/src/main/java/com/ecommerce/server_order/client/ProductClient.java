package com.ecommerce.server_order.client;

import com.ecommerce.server_order.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "server-product")
public interface ProductClient {
    @GetMapping("/api/products/{id}") ProductDTO getProductById(@PathVariable("id") Long id);

    // pour exercice 1 etape 13
    @PutMapping("/api/products/{id}/stock")
    void updateProductStock(@PathVariable("id") Long id, @RequestParam("quantity") Integer quantity);
}
