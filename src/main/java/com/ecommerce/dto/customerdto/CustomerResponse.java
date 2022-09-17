package com.ecommerce.dto.customerdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse extends CustomerReq {

    private int customerId;
}
