package com.ecommerce.service;

import com.ecommerce.dto.ProductReq;
import com.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getProducts();

}
