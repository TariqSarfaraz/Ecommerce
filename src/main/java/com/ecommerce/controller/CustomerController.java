package com.ecommerce.controller;

import com.ecommerce.dto.CustomerReq;
import com.ecommerce.dto.OrderReq;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Order;
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
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerReq customerReq) {
        Customer customer = customerService.addCustomer(customerReq);
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/{cid}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int cid) {
        Customer customer = customerService.getCustomerById(cid);
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        return ResponseEntity.ok(allCustomers);
    }

    @PostMapping("/orders/{cid}")
    public ResponseEntity<Order> addOrder(@PathVariable int cid, @RequestBody Order orderReq) {
        Order order = customerService.purchaseProducts(cid, orderReq);
        return ResponseEntity.ok(order);
    }

}
