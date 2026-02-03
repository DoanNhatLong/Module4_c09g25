package com.example.ss8_validator.service;

import com.example.ss8_validator.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();


    String borrow(Long id);
}
