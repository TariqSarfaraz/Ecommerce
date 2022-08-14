package com.ecommerce.controller;

import com.ecommerce.dto.CustomerReq;
import com.ecommerce.dto.CustomerResponse;
import com.ecommerce.entity.Customer;
import com.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> addCustomer(@RequestBody CustomerReq customerReq) {
        CustomerResponse customer = customerService.addCustomer(customerReq);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{cid}")
    public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable int cid) {
        CustomerResponse customer = customerService.getCustomerById(cid);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {
        List<CustomerResponse> allCustomers = customerService.getAllCustomers();
        return ResponseEntity.ok(allCustomers);
    }

}
