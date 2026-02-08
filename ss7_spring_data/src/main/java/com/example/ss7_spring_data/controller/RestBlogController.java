package com.example.ss7_spring_data.controller;

import com.example.ss7_spring_data.dto.ViewDto;
import com.example.ss7_spring_data.entity.Category;
import com.example.ss7_spring_data.service.IBlogService;
import com.example.ss7_spring_data.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public Page<ViewDto> getAllBlogs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return blogService.findAllView(pageable);
    }

    @GetMapping("category")
    public ResponseEntity<List<Category>> getAllCategories(){
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/search/{categoryId}")
    public ResponseEntity<Page<ViewDto>> searchByCategoryId(
            @PathVariable Integer categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ViewDto> blogPage = blogService.searchByCategoryId(categoryId, pageable);
        if (blogPage.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(blogPage);
    }
}
