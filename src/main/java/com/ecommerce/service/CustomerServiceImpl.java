package com.ecommerce.service;

import com.ecommerce.dto.CustomerReq;
import com.ecommerce.dto.CustomerResponse;
import com.ecommerce.entity.Customer;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public ResponseEntity<CustomerResponse> addCustomer(CustomerReq customerReq) {

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerReq, customer);

        CustomerResponse response = new CustomerResponse();
        Customer resp = customerRepository.save(customer);
        BeanUtils.copyProperties(resp, response);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<CustomerResponse> getCustomerById(int cid) {

        CustomerResponse response = new CustomerResponse();
        Customer customer = customerRepository.findById(cid).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
        BeanUtils.copyProperties(customer, response);

        return ResponseEntity.ok(response);

    }

    @Override
    public ResponseEntity<List<CustomerResponse>> getAllCustomers() {

        List<CustomerResponse> response = new ArrayList<>();
        List<Customer> customers = customerRepository.findAll();

        for (Customer customer : customers) {
            CustomerResponse customerResponse = new CustomerResponse();
            BeanUtils.copyProperties(customer, customerResponse);
            response.add(customerResponse);
        }

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<String> deleteCustomerById(int cid) {

        customerRepository.findById(cid).orElseThrow(()-> new ResourceNotFoundException("User Not Found"));
        customerRepository.deleteById(cid);

        return ResponseEntity.ok("Deleted");
    }

    @Override
    public ResponseEntity<CustomerResponse> updateCustomerById(int cid, CustomerReq customerReq) {

        Customer customer = customerRepository.findById(cid).orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
        BeanUtils.copyProperties(customerReq, customer);
        Customer resp = customerRepository.save(customer);

        CustomerResponse response = new CustomerResponse();
        BeanUtils.copyProperties(resp, response);

        return ResponseEntity.ok(response);
    }
}
