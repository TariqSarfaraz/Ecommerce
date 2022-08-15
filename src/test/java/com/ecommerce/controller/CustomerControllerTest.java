package com.ecommerce.controller;

import com.ecommerce.dto.CustomerResponse;
import com.ecommerce.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class CustomerControllerTest {

    @Mock
    private CustomerService customerService;

    @InjectMocks
    private CustomerController customerController;

    @Test
    void getCustomerById_Success() {

        // Given
        int id = 1;
        CustomerResponse response = new CustomerResponse(1);
        ResponseEntity<CustomerResponse> expected = new ResponseEntity<>(response, HttpStatus.OK);
        Mockito.when(customerService.getCustomerById(id)).thenReturn(expected);

        // When
        ResponseEntity<CustomerResponse> actual = customerController.getCustomerById(id);

        // Then
        assertThat(actual).isEqualTo(expected);
    }

    void getCustomerById() {
        
    }
}