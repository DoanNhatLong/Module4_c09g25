package com.example.ss3_thymeleaf.service;

import com.example.ss3_thymeleaf.entity.Product;
import com.example.ss3_thymeleaf.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public boolean deleteByID(int id) {
        return productRepository.deleteByID(id);
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public Product findByID(int id) {
        return productRepository.findByID(id);
    }
}
