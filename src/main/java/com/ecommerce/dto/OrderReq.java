package com.ecommerce.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderReq {

    private List<ProductReq> productReq;
}
