package com.example.ss7_spring_data.controller;

import com.example.ss7_spring_data.dto.ViewDto;
import com.example.ss7_spring_data.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@RequestMapping("/blogs")
@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping()
    public String getAllBlogs(Model model) {
        List<ViewDto> blogs = blogService.findAllView();
        model.addAttribute("blogs", blogs);
        return "/blog/list";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id){
        blogService.delete(id);
        return "redirect:/blogs";
    }
}