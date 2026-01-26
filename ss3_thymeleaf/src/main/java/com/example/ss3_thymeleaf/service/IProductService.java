package com.example.ss3_thymeleaf.service;

import com.example.ss3_thymeleaf.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    boolean deleteByID(int id);

    void add(Product product);

    Product findByID(int id);
}
