package com.ecommerce.service;

import com.ecommerce.dto.CustomerReq;
import com.ecommerce.dto.CustomerResponse;
import com.ecommerce.entity.Customer;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public CustomerResponse addCustomer(CustomerReq customerReq) {

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerReq, customer);

        CustomerResponse response = new CustomerResponse();
        Customer resp = customerRepository.save(customer);
        BeanUtils.copyProperties(resp, response);

        return response;
    }

    @Override
    public CustomerResponse getCustomerById(int id) {

        CustomerResponse response = new CustomerResponse();
        Customer customer = customerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
        BeanUtils.copyProperties(customer, response);

        return response;

    }

    @Override
    public List<CustomerResponse> getAllCustomers() {

        List<CustomerResponse> response = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();

        for (Customer customer : customers) {
            CustomerResponse customerResponse = new CustomerResponse();
            BeanUtils.copyProperties(customer, customerResponse);
            response.add(customerResponse);
        }

        return response;
    }
}
