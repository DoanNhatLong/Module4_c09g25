package com.example.ss7_spring_data.service;

import com.example.ss7_spring_data.dto.SearchDto;
import com.example.ss7_spring_data.dto.ViewDto;
import com.example.ss7_spring_data.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<ViewDto> findAllView(Pageable pageable);
    boolean delete(int id);
    void add(Blog blog);

    Page<ViewDto> search(SearchDto searchDto, Pageable pageable);
}
