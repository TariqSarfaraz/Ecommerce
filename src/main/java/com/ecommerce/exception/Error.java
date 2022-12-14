package com.ecommerce.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Error {

    private String errorMessage;
    private int errorCode;
    private Date timestamp;
}
