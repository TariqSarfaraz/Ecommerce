package com.ecommerce.service;

import com.ecommerce.dto.CartResponse;

import java.util.List;

public interface CartService {

    List<CartResponse> getCartItemByCustomerId(int cid);

    String addProductToCart(int pid, int cid, int quantity);
}
