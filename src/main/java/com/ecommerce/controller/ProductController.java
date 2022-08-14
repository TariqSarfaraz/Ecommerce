package com.ecommerce.controller;

import com.ecommerce.dto.ProductReq;
import com.ecommerce.dto.ProductResponse;
import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody ProductReq productReq) {
        Product product = productService.addProduct(productReq);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{pid}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable int pid) {
        ProductResponse product = productService.getProductById(pid);
        return ResponseEntity.ok(product);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<ProductResponse> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }
}
