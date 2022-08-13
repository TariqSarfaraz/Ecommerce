package com.ecommerce.service;

import com.ecommerce.dto.CustomerReq;
import com.ecommerce.dto.OrderReq;
import com.ecommerce.dto.ProductReq;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Order;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.OrderRepository;
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
    public Order purchaseProducts(int cid, Order order) {
        Customer customer = customerRepository.findById(cid).get();
        order.setCustomer(customer);
        return orderRepository.save(order);
    }

//    @Override
//    public Order purchaseProducts(int cid, OrderReq orderReq) {
//
//        Customer customer = customerRepository.findById(cid).get();
//
//        Order order = new Order();
//        List<Product> products = new ArrayList<>();
//        List<ProductReq> productReq = orderReq.getProductReq();
//        Product product = new Product();
//
//        for(ProductReq req:productReq){
//            BeanUtils.copyProperties(req, product);
//            products.add(product);
//        }
//
//        order.setCustomer(customer);
//        order.setProducts(products);
//
//        return orderRepository.save(order);
//    }

}
