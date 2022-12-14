package com.ecommerce.service;

import com.ecommerce.dto.cartdto.CartResponse;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.utils.Constants;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ResponseEntity<List<CartResponse>> getCartItemByCustomerId(int cid) {

        List<CartResponse> cartResponses = new ArrayList<>();

        Customer customer = customerRepository.findById(cid).orElseThrow(() -> new ResourceNotFoundException(Constants.USERNOTFOUND));
        List<Cart> cartItems = cartRepository.findByCustomer(customer);

        for (Cart cart : cartItems) {
            CartResponse cartResponse = new CartResponse();

            cartResponse.setQuantity(cart.getQuantity());
            cartResponse.setProduct((Product) Hibernate.unproxy(cart.getProduct()));

            cartResponses.add(cartResponse);
        }

        return ResponseEntity.ok(cartResponses);
    }

    @Override
    public ResponseEntity<String> addProductToCart(int pid, int cid, int quantity) {

        Cart cart = new Cart();
        Customer customer = customerRepository.findById(cid).orElseThrow(() -> new ResourceNotFoundException(Constants.USERNOTFOUND));
        Product product = productRepository.findById(pid).orElseThrow(() -> new ResourceNotFoundException(Constants.PRODUCTNOTFOUND));

        cart.setProduct(product);
        cart.setCustomer(customer);
        cart.setQuantity(quantity);

        cartRepository.save(cart);

        return ResponseEntity.ok("Product added to the Cart");
    }
}
