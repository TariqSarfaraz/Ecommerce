package com.ecommerce.dto;

import lombok.Data;

@Data
public class ProductReq {

    private String productName;
    private double productPrice;
    private String productDescription;

}
