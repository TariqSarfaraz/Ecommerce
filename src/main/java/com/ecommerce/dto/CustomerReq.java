package com.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerReq {

    private String customerName;
    private String customerEmail;
    private String customerAddress;
    private long customerPhone;
}
