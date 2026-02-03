package com.example.ss8_validator.service;

import com.example.ss8_validator.entity.CodeBook;
import com.example.ss8_validator.repository.IBookRepository;
import com.example.ss8_validator.repository.ICodeBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeBookService implements ICodeBookService {
    @Autowired
    private ICodeBookRepository codeBookRepository;

    @Override
    public List<CodeBook> findAll() {
        return codeBookRepository.findAll();
    }

    @Override
    public void save(CodeBook codeBook) {
        codeBookRepository.save(codeBook);
    }
}
