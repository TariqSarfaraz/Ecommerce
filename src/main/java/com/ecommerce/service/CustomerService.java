package com.ecommerce.service;

import com.ecommerce.dto.customerdto.CustomerReq;
import com.ecommerce.entity.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

    ResponseEntity<Customer> addCustomer(CustomerReq customerReq);

    ResponseEntity<Customer> getCustomerById(int cid);

    ResponseEntity<List<Customer>> getAllCustomers();

    ResponseEntity<String> deleteCustomerById(int cid);

    ResponseEntity<Customer> updateCustomerById(int cid, CustomerReq customerReq);
}
