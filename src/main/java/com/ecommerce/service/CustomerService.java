package com.ecommerce.service;

import com.ecommerce.dto.CustomerReq;
import com.ecommerce.dto.OrderReq;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Order;

import java.util.List;

public interface CustomerService {

    public Customer addCustomer(CustomerReq customerReq);

    public Customer getCustomerById(int id);

    public List<Customer> getAllCustomers();

//    public Order purchaseProducts(int cid, OrderReq orderReq);

    public Order purchaseProducts(int cid, Order order);
}
