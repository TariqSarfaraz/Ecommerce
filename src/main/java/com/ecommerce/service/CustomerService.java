package com.ecommerce.service;

import com.ecommerce.dto.customerdto.CustomerReq;
import com.ecommerce.dto.customerdto.CustomerResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

    ResponseEntity<CustomerResponse> addCustomer(CustomerReq customerReq);

    ResponseEntity<CustomerResponse> getCustomerById(int cid);

    ResponseEntity<List<CustomerResponse>> getAllCustomers();

    ResponseEntity<String> deleteCustomerById(int cid);

    ResponseEntity<CustomerResponse> updateCustomerById(int cid, CustomerReq customerReq);
}
