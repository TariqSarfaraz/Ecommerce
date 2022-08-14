package com.ecommerce.controller;

import com.ecommerce.dto.CartResponse;
import com.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class CartController {

    @Autowired
    CartService cartService;

    @GetMapping("/{cid}")
    public ResponseEntity<List<CartResponse>> getCartItem(@PathVariable int cid) {
        List<CartResponse> cartItems = cartService.getCartItemByCustomerId(cid);
        return ResponseEntity.ok(cartItems);
    }

    @PostMapping("/{pid}/{cid}/{quantity}")
    public ResponseEntity<String> addProductToCart(@PathVariable int pid, @PathVariable int cid, @PathVariable int quantity) {
        String resp = cartService.addProductToCart(pid, cid, quantity);
        return ResponseEntity.ok(resp);
    }

}
