package com.ecommerce.service;

import com.ecommerce.dto.CustomerResponse;
import com.ecommerce.dto.ProductReq;
import com.ecommerce.dto.ProductResponse;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
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

        Product resp = productRepository.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
        ProductResponse product = new ProductResponse();

        BeanUtils.copyProperties(resp, product);

        return product;
    }

    @Override
    public List<ProductResponse> getAllProducts() {

        List<ProductResponse> products = new ArrayList<>();
        List<Product> resp = productRepository.findAll();

        for (Product product : resp) {
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(product, productResponse);

            products.add(productResponse);
        }

        return products;
    }

    @Override
    public String deleteProduct(int pid) {

        productRepository.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
        productRepository.deleteById(pid);

        return "Deleted";
    }

    @Override
    public ProductResponse updateProduct(int pid, ProductReq productReq) {

        Product product = productRepository.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
        BeanUtils.copyProperties(productReq, product);
        Product resp = productRepository.save(product);

        ProductResponse response = new ProductResponse();
        BeanUtils.copyProperties(resp, response);

        return response;
    }
}
