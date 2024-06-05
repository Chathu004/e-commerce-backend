package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Cart;
import org.example.entity.CartEntity;
import org.example.entity.CommonEntity;
import org.example.entity.UserEntity;
import org.example.repository.CartRepository;
import org.example.repository.CommonRepository;
import org.example.repository.UserRepository;
import org.example.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    final CartRepository cartRepository;
    private final CommonRepository commonRepository;
    private final UserRepository userRepository;
    final ModelMapper mapper;
    @Override
    public CartEntity createCart(Cart cart) {
        if (cart.getId() == null || cart.getUserId() == null) {
            System.out.println(cart.getCartId());
            System.out.println(cart.getUserId());
            System.out.println(cart.getId());

            throw new IllegalArgumentException("Product ID and Customer ID must not be null");
        }

        CommonEntity commonEntity = commonRepository.findById(cart.getId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid product ID: " + cart.getId()));
        UserEntity userEntity = userRepository.findById(cart.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid customer ID: " + cart.getUserId()));

        CartEntity cartEntity = new CartEntity();
        cartEntity.setCommonEntity(commonEntity);
        cartEntity.setUserEntity(userEntity);
        cartEntity.setQty(cart.getQty());
        cartEntity.setProductTot(cart.getProductTot());
        cartEntity.setComplete(false);
        cartEntity.setProductName(commonEntity.getName());
        cartEntity.setProductImgURL(commonEntity.getImgURL());


        return cartRepository.save(cartEntity);
//        CartEntity cartEntity = new CartEntity();
//        CommonEntity commonEntity = commonRepository.findById(cart.getProductId()).orElseThrow();
//        UserEntity userEntity = userRepository.findById(cart.getCustomerId()).orElseThrow();
//        cartEntity.setCommonEntity(commonEntity);
//        cartEntity.setUserEntity(userEntity);
//        cartEntity.setQty(cart.getQty());
//        cartEntity.setProductTot(cart.getProductTot());
//        cartEntity.setComplete(false);
//        return cartRepository.save(cartEntity);
    }

    @Override
    public List<CartEntity> getCartByUserId(Long userId) {
        return cartRepository.findByUserEntityUserId(userId);
    }

//    @Override
//    public CartEntity createCart(Cart cart) {
//        return null;
//    }
}
