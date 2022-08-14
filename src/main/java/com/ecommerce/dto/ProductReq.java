package com.ecommerce.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ProductReq {

    @NotBlank(message = "Name cannot be blank")
    private String productName;
    private double productPrice;
    @NotBlank(message = "Description cannot be blank")
    private String productDescription;

}
