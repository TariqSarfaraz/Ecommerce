package com.ecommerce.service;

import com.ecommerce.dto.ProductReq;
import com.ecommerce.dto.ProductResponse;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product addProduct(ProductReq productReq) {

        Product product = new Product();
        BeanUtils.copyProperties(productReq, product);

        return productRepository.save(product);
    }

    @Override
    public ProductResponse getProductById(int pid) {

        Product resp = productRepository.findById(pid).get();
        ProductResponse product = new ProductResponse();

        product.setProductId(resp.getProductId());
        product.setProductName(resp.getProductName());
        product.setProductDescription(resp.getProductDescription());
        product.setProductPrice(resp.getProductPrice());

        return product;
    }

    @Override
    public List<ProductResponse> getAllProducts() {

        ProductResponse productResponse = new ProductResponse();
        List<ProductResponse> products = new ArrayList<>();
        List<Product> resp = productRepository.findAll();

        for (Product product : resp) {

            productResponse.setProductId(product.getProductId());
            productResponse.setProductName(product.getProductName());
            productResponse.setProductPrice(product.getProductPrice());
            productResponse.setProductDescription(product.getProductDescription());

            products.add(productResponse);
        }

        return products;
    }
}
