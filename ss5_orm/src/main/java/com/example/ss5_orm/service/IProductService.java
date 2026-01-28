package com.example.ss5_orm.service;

import com.example.ss5_orm.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    boolean deleteByID(int id);

    void add(Product product);

    Product findByID(int id);
}
