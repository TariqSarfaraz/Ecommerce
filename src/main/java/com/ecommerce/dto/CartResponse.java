package com.ecommerce.dto;

import lombok.Data;

@Data
public class CartResponse {

    private int cartId;
    private int quantity;
    private int customerId;
    private int productId;
}
