package com.ecommerce.service;

import com.ecommerce.dto.CustomerReq;
import com.ecommerce.entity.Customer;

import java.util.List;

public interface CustomerService {

    public Customer addCustomer(CustomerReq customerReq);

    public Customer getCustomerById(int id);

    public List<Customer> getAllCustomers();

}
