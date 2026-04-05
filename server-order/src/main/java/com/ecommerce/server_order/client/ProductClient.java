package com.ecommerce.server_order.client;

import com.ecommerce.server_order.dto.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

// On lie l'interface à sa classe de secours
@FeignClient(name = "SERVER-PRODUCT", fallback = ProductFallback.class)
public interface ProductClient {

    @GetMapping("/api/products/{id}")
    ProductDTO getProductById(@PathVariable("id") Long id);

    @PutMapping("/api/products/{id}/stock")
    void updateProductStock(@PathVariable("id") Long id, @RequestParam("quantity") Integer quantity);
}