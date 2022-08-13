package com.ecommerce.controller;

import com.ecommerce.dto.OrderReq;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/{cid}")
    public ResponseEntity<String> addOrder(@PathVariable int cid, @RequestBody OrderReq orderReq) {

        String resp = orderService.addOrder(cid, orderReq);
        return ResponseEntity.ok(resp);
    }

}
