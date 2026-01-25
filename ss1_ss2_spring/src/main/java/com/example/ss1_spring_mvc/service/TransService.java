package com.example.ss1_spring_mvc.service;

import com.example.ss1_spring_mvc.repository.ITransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransService implements ITransService {
    @Autowired
    private ITransRepository transRepository;
    @Override
    public String findWord(String word) {
        return transRepository.findWord(word);
    }
}
