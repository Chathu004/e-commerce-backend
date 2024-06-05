package org.example.service;

import org.example.dto.Cart;
import org.example.dto.Category;
import org.example.entity.CartEntity;

import java.util.List;

public interface CartService {
    CartEntity createCart(Cart cart);
//    CartEntity createCart(CartEntity cartEntity);
    List<CartEntity> getCartByUserId(Long userId);



}
