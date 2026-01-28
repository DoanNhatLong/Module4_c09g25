package com.example.ss5_orm.repository;

import com.example.ss5_orm.entity.Product;
import jakarta.persistence.*;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> typedQuery=entityManager.createQuery("from Product ", Product.class);
        return typedQuery.getResultList();
    }

    @Override
    public Product findByID(int id){
        return entityManager.find(Product.class,id);

    }

    @Transactional
    @Override
    public boolean deleteByID(int id) {
        Product temp=findByID(id);
        if (temp !=null){
            try {
                entityManager.remove(temp);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    @Transactional
    @Override
    public void add(Product product) {
        try {
            entityManager.merge(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
