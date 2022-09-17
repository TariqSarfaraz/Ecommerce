package com.ecommerce.service;

import com.ecommerce.dto.cartdto.CartResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartService {

    ResponseEntity<List<CartResponse>> getCartItemByCustomerId(int cid);

    ResponseEntity<String> addProductToCart(int pid, int cid, int quantity);
}
