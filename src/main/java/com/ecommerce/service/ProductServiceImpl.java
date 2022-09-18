package com.ecommerce.service;

import com.ecommerce.dto.productdto.ProductReq;
import com.ecommerce.entity.Product;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.utils.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseEntity<Product> addProduct(ProductReq productReq) {

        Product product = new Product();
        BeanUtils.copyProperties(productReq, product);

        product = productRepository.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @Override
    public ResponseEntity<Product> getProductById(int pid) {

        Product product = productRepository.findById(pid).orElseThrow(() -> new ResourceNotFoundException(Constants.PRODUCTNOTFOUND));

        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {

        List<Product> products = productRepository.findAll();
        return ResponseEntity.ok(products);
    }

    @Override
    public ResponseEntity<String> deleteProduct(int pid) {

        productRepository.findById(pid).orElseThrow(() -> new ResourceNotFoundException(Constants.PRODUCTNOTFOUND));
        productRepository.deleteById(pid);

        return ResponseEntity.ok("Deleted");
    }

    @Override
    public ResponseEntity<Product> updateProduct(int pid, ProductReq productReq) {

        Product product = productRepository.findById(pid).orElseThrow(() -> new ResourceNotFoundException(Constants.PRODUCTNOTFOUND));
        BeanUtils.copyProperties(productReq, product);
        product = productRepository.save(product);

        return ResponseEntity.ok(product);
    }
}
