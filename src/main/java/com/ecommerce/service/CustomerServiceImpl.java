package com.ecommerce.service;

import com.ecommerce.dto.customerdto.CustomerReq;
import com.ecommerce.entity.Customer;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.utils.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public ResponseEntity<Customer> addCustomer(CustomerReq customerReq) {

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerReq, customer);
        customer = customerRepository.save(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }

    @Override
    public ResponseEntity<Customer> getCustomerById(int cid) {

        Customer customer = customerRepository.findById(cid).orElseThrow(() -> new ResourceNotFoundException(Constants.USERNOTFOUND));

        return ResponseEntity.ok(customer);

    }

    @Override
    public ResponseEntity<List<Customer>> getAllCustomers() {

        List<Customer> customers = customerRepository.findAll();
        return ResponseEntity.ok(customers);
    }

    @Override
    public ResponseEntity<String> deleteCustomerById(int cid) {

        customerRepository.findById(cid).orElseThrow(() -> new ResourceNotFoundException(Constants.USERNOTFOUND));
        customerRepository.deleteById(cid);

        return ResponseEntity.ok("Deleted");
    }

    @Override
    public ResponseEntity<Customer> updateCustomerById(int cid, CustomerReq customerReq) {

        Customer customer = customerRepository.findById(cid).orElseThrow(() -> new ResourceNotFoundException(Constants.USERNOTFOUND));
        BeanUtils.copyProperties(customerReq, customer);
        customer = customerRepository.save(customer);

        return ResponseEntity.ok(customer);
    }
}
