package com.ecommerce.service;

import com.ecommerce.dto.ProductReq;
import com.ecommerce.dto.ProductResponse;
import com.ecommerce.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    ResponseEntity<Product> addProduct(ProductReq productReq);

    ResponseEntity<ProductResponse> getProductById(int pid);

    ResponseEntity<List<ProductResponse>> getAllProducts();

    ResponseEntity<String> deleteProduct(int pid);

    ResponseEntity<ProductResponse> updateProduct(int pid, ProductReq productReq);
}
