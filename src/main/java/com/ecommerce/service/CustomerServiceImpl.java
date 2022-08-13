package com.ecommerce.service;

import com.ecommerce.dto.CustomerReq;
import com.ecommerce.dto.ProductReq;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.OrderRepository;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Customer addCustomer(CustomerReq customerReq) {

        Customer customer = new Customer();
        customer.setCustomerName(customerReq.getCustomerName());
        customer.setCustomerEmail(customerReq.getCustomerEmail());
        customer.setCustomerAddress(customerReq.getCustomerAddress());
        customer.setCustomerPhone(customerReq.getCustomerPhone());

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

    @Override
    public Order purchaseProducts(int cid, int[] pid) {

        List<Product> products = new ArrayList<>();
        Order order = new Order();

        Customer customer = customerRepository.findById(cid).get();

        for(Integer i:pid){
            Product product = productRepository.findById(i).get();
            products.add(product);
        }

        order.setProducts(products);
        order.setCustomer(customer);

        return orderRepository.save(order);
    }


}
