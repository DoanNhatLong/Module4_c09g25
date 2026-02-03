package com.example.ss8_validator.repository;

import com.example.ss8_validator.entity.CodeBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodeBookRepository extends JpaRepository<CodeBook, Long> {
}
