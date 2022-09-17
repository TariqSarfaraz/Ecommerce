package com.ecommerce.service;

import com.ecommerce.dto.productdto.ProductReq;
import com.ecommerce.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<Product> addProduct(ProductReq productReq);

    ResponseEntity<Product> getProductById(int pid);

    ResponseEntity<List<Product>> getAllProducts();

    ResponseEntity<String> deleteProduct(int pid);

    ResponseEntity<Product> updateProduct(int pid, ProductReq productReq);
}
