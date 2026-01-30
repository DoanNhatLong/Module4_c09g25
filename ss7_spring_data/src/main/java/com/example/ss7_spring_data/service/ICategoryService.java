package com.example.ss7_spring_data.service;

import com.example.ss7_spring_data.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> findAll();
}
