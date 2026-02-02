package com.example.ss8_validator.service;

import com.example.ss8_validator.entity.User;
import com.example.ss8_validator.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean save(User user) {
        userRepository.save(user);
        return true;
    }
}
