package com.ecommerce.service;

import com.ecommerce.dto.CustomerReq;
import com.ecommerce.dto.CustomerResponse;
import com.ecommerce.entity.Customer;

import java.util.List;

public interface CustomerService {

    public CustomerResponse addCustomer(CustomerReq customerReq);

    public CustomerResponse getCustomerById(int cid);

    public List<CustomerResponse> getAllCustomers();

    String deleteCustomerById(int cid);

    CustomerResponse updateCustomerById(int cid, CustomerReq customerReq);
}
