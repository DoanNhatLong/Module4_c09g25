package com.example.ss8_validator.service;

import com.example.ss8_validator.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Product findById(Long id);
}
