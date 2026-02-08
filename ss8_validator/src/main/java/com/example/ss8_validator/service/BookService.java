package com.example.ss8_validator.service;

import com.example.ss8_validator.entity.Book;
import com.example.ss8_validator.repository.IBookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Transactional
@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public String borrow(Long id) {
        Book book=bookRepository.findById(id).orElse(null);
        if (book.getQuantity()<=0){
            throw new RuntimeException("Đã hết sách");
        } else {
            book.setQuantity(book.getQuantity()-1);
            return generateCode();
        }
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }


    private String generateCode() {
        int code = 10000 + new Random().nextInt(90000);
        return String.valueOf(code);
    }
}
