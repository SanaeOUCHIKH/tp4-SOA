package com.ecommerce.server_order.controller;

import com.ecommerce.server_order.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Capture l'erreur "Produit inexistant" lancée dans le service
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleProductNotFound(RuntimeException ex) {
        ErrorResponse error = new ErrorResponse("Le produit demandé n'existe pas.", 404);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // Capture l'erreur si le serveur distant (Product Service) est éteint
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalError(Exception ex) {
        ErrorResponse error = new ErrorResponse("Le service Produit est injoignable pour le moment.", 503);
        return new ResponseEntity<>(error, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
