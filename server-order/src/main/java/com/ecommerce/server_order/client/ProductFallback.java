package com.ecommerce.server_order.client;

import com.ecommerce.server_order.dto.ProductDTO;
import org.springframework.stereotype.Component;

@Component
public class ProductFallback implements ProductClient {
    @Override
    public ProductDTO getProductById(Long id) {
        // Au lieu de crash, on renvoie null. Le service verra le null et lancera l'erreur 404 propre.
        return null;
    }
    @Override
    public void updateProductStock(Long id, Integer quantity) {
        // En cas de panne, on ne peut pas mettre à jour le stock.
        // On ne fait rien ou on pourrait logger une erreur ici.
    }
}
