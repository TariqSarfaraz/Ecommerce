package com.ecommerce.controller;

import com.ecommerce.dto.customerdto.CustomerReq;
import com.ecommerce.entity.Customer;
import com.ecommerce.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@Valid @RequestBody CustomerReq customerReq) {
        return customerService.addCustomer(customerReq);
    }

    @GetMapping("/{cid}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int cid) {
        return customerService.getCustomerById(cid);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PutMapping("/{cid}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable int cid,@Valid @RequestBody CustomerReq customerReq) {
        return customerService.updateCustomerById(cid, customerReq);
    }

    @DeleteMapping("/{cid}")
    public ResponseEntity<String> deleteCustomerById(@PathVariable int cid) {
        return customerService.deleteCustomerById(cid);
    }

}
