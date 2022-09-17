package com.ecommerce.dto.cartdto;

import com.ecommerce.dto.customerdto.CustomerResponse;
import com.ecommerce.dto.productdto.ProductResponse;
import lombok.Data;

@Data
public class CartResponse {

    private int quantity;
    private ProductResponse product;
}
