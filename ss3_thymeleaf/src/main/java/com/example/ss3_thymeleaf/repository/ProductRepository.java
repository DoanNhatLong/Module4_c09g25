package com.example.ss3_thymeleaf.repository;

import com.example.ss3_thymeleaf.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    final static private List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Bàn", 2, 1000));
        productList.add(new Product(2, "Chuôt", 1, 2000));
        productList.add(new Product(3, "Ghế", 3, 10030));
        productList.add(new Product(3, "Lap", 1, 10004));
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public boolean deleteByID(int id) {
        return productList.removeIf(p -> p.getId() == id);
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public Product findByID(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
