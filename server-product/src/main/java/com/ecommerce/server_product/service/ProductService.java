package com.ecommerce.server_product.service;

import com.ecommerce.server_product.model.Product;
import com.ecommerce.server_product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List; import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> getAllProducts() {         return productRepository.findAll();     }
    public Optional<Product> getProductById(Long id) {         return productRepository.findById(id);     }
    public Product createProduct(Product product) {         return productRepository.save(product);     }
    public void deleteProduct(Long id) {         productRepository.deleteById(id);     }
}
