package com.example.ss7_spring_data.service;

import com.example.ss7_spring_data.dto.ViewDto;
import com.example.ss7_spring_data.repository.iBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private iBlogRepository blogRepository;

    @Override
    public List<ViewDto> findAllView() {
        return blogRepository.findAllView();
    }

    @Override
    public boolean delete(int id) {
        try {
            blogRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
