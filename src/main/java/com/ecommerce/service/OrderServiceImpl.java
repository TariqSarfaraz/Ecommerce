package com.ecommerce.service;

import com.ecommerce.dto.OrderReq;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Order;
import com.ecommerce.repository.CustomerRepository;
import com.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public String addOrder(int cid, OrderReq orderReq) {

        Customer customer = customerRepository.findById(cid).get();

        Order order = new Order();
        order.setOrderDescription(orderReq.getOrderDescription());
        order.setCustomer(customer);

        orderRepository.save(order);

        return "Added";
    }
}
