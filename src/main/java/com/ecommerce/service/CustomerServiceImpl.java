package com.ecommerce.service;

import com.ecommerce.dto.CustomerReq;
import com.ecommerce.entity.Customer;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.CartRepository;
import com.ecommerce.repository.ProductRepository;
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
    public Customer addCustomer(CustomerReq customerReq) {

        Customer customer = new Customer();
//        customer.setCustomerName(customerReq.getCustomerName());
//        customer.setCustomerEmail(customerReq.getCustomerEmail());
//        customer.setCustomerAddress(customerReq.getCustomerAddress());
//        customer.setCustomerPhone(customerReq.getCustomerPhone());

        BeanUtils.copyProperties(customerReq, customer);

        return customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}
