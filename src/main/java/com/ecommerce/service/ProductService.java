package com.ecommerce.service;

import com.ecommerce.dto.ProductReq;
import com.ecommerce.dto.ProductResponse;
import com.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {

    public Product addProduct(ProductReq productReq);

    ProductResponse getProductById(int pid);

    List<ProductResponse> getAllProducts();

    String deleteProduct(int pid);

    ProductResponse updateProduct(int pid, ProductReq productReq);
}
