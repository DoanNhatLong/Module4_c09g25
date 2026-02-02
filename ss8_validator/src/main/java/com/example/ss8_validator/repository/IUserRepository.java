package com.example.ss8_validator.repository;

import com.example.ss8_validator.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
}
