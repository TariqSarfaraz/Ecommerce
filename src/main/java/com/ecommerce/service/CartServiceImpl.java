package com.ecommerce.service;

import com.ecommerce.dto.CartResponse;
import com.ecommerce.entity.Cart;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<CartResponse> getCartItemByCustomerId(int cid) {

        CartResponse cartResponse = new CartResponse();
        List<CartResponse> cartResponses = new ArrayList<>();
        Customer customer = customerRepository.findById(cid).get();
        List<Cart> cartItems = cartRepository.findByCustomer(customer);

        for (Cart cart : cartItems) {

            cartResponse.setCartId(cart.getCartId());
            cartResponse.setQuantity(cart.getQuantity());
            cartResponse.setCustomerId(cart.getCustomer().getCustomerId());
            cartResponse.setProductId(cart.getProduct().getProductId());

            cartResponses.add(cartResponse);
        }

        return cartResponses;
    }

    @Override
    public String addProductToCart(int pid, int cid, int quantity) {

        Cart cart = new Cart();
        Product product = productRepository.findById(pid).get();
        Customer customer = customerRepository.findById(cid).get();

        cart.setProduct(product);
        cart.setCustomer(customer);
        cart.setQuantity(quantity);

        cartRepository.save(cart);

        return "Product added to the Cart";
    }
}
