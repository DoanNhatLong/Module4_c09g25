package com.example.ss7_spring_data.service;

import com.example.ss7_spring_data.dto.SearchDto;
import com.example.ss7_spring_data.dto.ViewDto;
import com.example.ss7_spring_data.entity.Blog;
import com.example.ss7_spring_data.repository.iBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private iBlogRepository blogRepository;

    @Override
    public Page<ViewDto> findAllView(Pageable pageable) {
        return blogRepository.findAllView(pageable);
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

    @Override
    public void add(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Page<ViewDto> search(SearchDto searchDto, Pageable pageable) {
        return blogRepository.search(
                searchDto.getTittle(),
                searchDto.getContent(),
                searchDto.getIdCategory(),
                pageable
        );
    }

    @Override
    public Page<ViewDto> searchByCategoryId(Integer categoryId, Pageable pageable) {
        return blogRepository.searchByCategoryId(categoryId, pageable);
    }


}
