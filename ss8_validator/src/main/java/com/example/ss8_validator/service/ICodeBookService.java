package com.example.ss8_validator.service;

import com.example.ss8_validator.entity.CodeBook;

import java.util.List;

public interface ICodeBookService {
    List<CodeBook> findAll();
    void save (CodeBook codeBook);
}
