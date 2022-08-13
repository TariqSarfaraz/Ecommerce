package com.ecommerce.service;

import com.ecommerce.dto.ProductReq;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product addProduct(ProductReq productReq) {

        Product product = new Product();
        product.setProductName(productReq.getProductName());
        product.setProductPrice(productReq.getProductPrice());
        product.setProductDescription(productReq.getProductDescription());

        return productRepository.save(product);
    }
}
