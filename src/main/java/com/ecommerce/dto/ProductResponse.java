package com.ecommerce.dto;

import lombok.Data;

@Data
public class ProductResponse {

    private int productId;
    private String productName;
    private double productPrice;
    private String productDescription; 
}
