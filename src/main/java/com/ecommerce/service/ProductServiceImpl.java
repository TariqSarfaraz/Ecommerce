package com.ecommerce.service;

import com.ecommerce.dto.productdto.ProductReq;
import com.ecommerce.dto.productdto.ProductResponse;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseEntity<ProductResponse> addProduct(ProductReq productReq) {

        Product product = new Product();
        ProductResponse response = new ProductResponse();
        BeanUtils.copyProperties(productReq, product);

        Product result = productRepository.save(product);
        BeanUtils.copyProperties(result, response);

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ProductResponse> getProductById(int pid) {

        Product resp = productRepository.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
        ProductResponse product = new ProductResponse();

        BeanUtils.copyProperties(resp, product);

        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<List<ProductResponse>> getAllProducts() {

        List<ProductResponse> products = new ArrayList<>();
        List<Product> resp = productRepository.findAll();

        for (Product product : resp) {
            ProductResponse productResponse = new ProductResponse();
            BeanUtils.copyProperties(product, productResponse);

            products.add(productResponse);
        }

        return ResponseEntity.ok(products);
    }

    @Override
    public ResponseEntity<String> deleteProduct(int pid) {

        productRepository.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
        productRepository.deleteById(pid);

        return ResponseEntity.ok("Deleted");
    }

    @Override
    public ResponseEntity<ProductResponse> updateProduct(int pid, ProductReq productReq) {

        Product product = productRepository.findById(pid).orElseThrow(() -> new ResourceNotFoundException("Product Not Found"));
        BeanUtils.copyProperties(productReq, product);
        Product resp = productRepository.save(product);

        ProductResponse response = new ProductResponse();
        BeanUtils.copyProperties(resp, response);

        return ResponseEntity.ok(response);
    }
}
