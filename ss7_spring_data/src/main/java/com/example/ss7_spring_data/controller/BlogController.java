package com.example.ss7_spring_data.controller;

import com.example.ss7_spring_data.dto.SearchDto;
import com.example.ss7_spring_data.dto.ViewDto;
import com.example.ss7_spring_data.entity.Blog;
import com.example.ss7_spring_data.entity.Category;
import com.example.ss7_spring_data.service.BlogService;
import com.example.ss7_spring_data.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/blogs")
@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;
    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("category")
    public List<Category> categories(){
        return categoryService.findAll();
    }

    @ModelAttribute("searchDto")
    public SearchDto searchDto(){
        return new SearchDto();
    }
    @GetMapping()
    public String getAllBlogs(
            @ModelAttribute SearchDto searchDto,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size,
            Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ViewDto> blogPage = blogService.search(searchDto, pageable);
        model.addAttribute("blogs", blogPage.getContent());
        model.addAttribute("currentPage", blogPage.getNumber());
        model.addAttribute("totalPages", blogPage.getTotalPages());
        model.addAttribute("size", size);
        model.addAttribute("hasNext", blogPage.hasNext());
        model.addAttribute("hasPrev", blogPage.hasPrevious());
        return "/blog/list";
    }

    @GetMapping("delete")
    public String delete(@RequestParam int id, RedirectAttributes redirectAttributes){
        blogService.delete(id);
        redirectAttributes.addFlashAttribute("message","Xóa thành công");
        return "redirect:/blogs";
    }

    @GetMapping("add")
    public String add(Model model){
        model.addAttribute("blog",new Blog());
        return "/blog/add";
    }

    @GetMapping("save")
    public String save(
            @ModelAttribute Blog blog,
            RedirectAttributes redirectAttributes
    ){
        blogService.add(blog);
        redirectAttributes.addFlashAttribute("message","Thêm mới thành công");
        return "redirect:/blogs";
    }

//    @GetMapping("search")
//    public String search(
//            Pageable pageable,
//            @ModelAttribute SearchDto searchDto,
//            Model model
//    ){
//        Page<ViewDto> blogs = blogService.search(searchDto, pageable);
//        model.addAttribute("blogs", blogs);
//        model.addAttribute("searchDto", searchDto);
//        return "/blog/list";
//    }
}