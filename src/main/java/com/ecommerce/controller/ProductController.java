package com.ecommerce.controller;

import com.ecommerce.dto.productdto.ProductReq;
import com.ecommerce.dto.productdto.ProductResponse;
import com.ecommerce.entity.Product;
import com.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@Valid @RequestBody ProductReq productReq) {
        return productService.addProduct(productReq);
    }

    @GetMapping("/{pid}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable int pid) {
        return productService.getProductById(pid);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("/{pid}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable int pid,@Valid @RequestBody ProductReq productReq) {
        return productService.updateProduct(pid, productReq);
    }

    @DeleteMapping("/{pid}")
    public ResponseEntity<String> deleteProduct(@PathVariable int pid) {
        return productService.deleteProduct(pid);
    }
}
