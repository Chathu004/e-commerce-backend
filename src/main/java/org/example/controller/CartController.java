package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Cart;
import org.example.dto.Category;
import org.example.entity.CartEntity;
import org.example.entity.CategoryEntity;
import org.example.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    final CartService service;
    @PostMapping("/add")
    public ResponseEntity<CartEntity> createCart(@RequestBody Cart cart){
        CartEntity entity = service.createCart(cart);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }
    @GetMapping("/customer/{userId}")
    public ResponseEntity<List<CartEntity>> getCartsByUserId(@PathVariable Long userId) {
        List<CartEntity> cartEntities = service.getCartByUserId(userId);
        return ResponseEntity.ok(cartEntities);
    }
}
