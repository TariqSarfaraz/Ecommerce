package com.ecommerce.dto.customerdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerReq {

    @NotBlank(message = "Name Cannot be Null")
    private String customerName;
    @NotBlank(message = "Email Cannot be Null")
    @Email
    private String customerEmail;
    @NotBlank(message = "Address Cannot be Null")
    private String customerAddress;
    private long customerPhone;
}
