package com.ecommerce.service;

import com.ecommerce.dto.OrderReq;
import com.ecommerce.entity.Order;

public interface OrderService {

    public String addOrder(int cid, OrderReq orderReq);
}
