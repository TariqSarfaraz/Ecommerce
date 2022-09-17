package com.ecommerce.dto.cartdto;

import com.ecommerce.entity.Product;
import lombok.Data;

@Data
public class CartResponse {

    private int quantity;
    private Product product;
}
