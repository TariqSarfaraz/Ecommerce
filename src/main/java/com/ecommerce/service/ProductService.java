package com.ecommerce.service;

import com.ecommerce.dto.ProductReq;
import com.ecommerce.entity.Product;

public interface ProductService {

    public Product addProduct(ProductReq productReq);

}
