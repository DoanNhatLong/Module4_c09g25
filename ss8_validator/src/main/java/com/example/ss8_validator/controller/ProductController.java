package com.example.ss8_validator.controller;

import com.example.ss8_validator.entity.Product;
import com.example.ss8_validator.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;

    @ModelAttribute ("flowers")
    public List<Product> initFlowers(){
        return productService.findAll();
    }

    @GetMapping("")
    public String goProduct(){
        return "/products/list";
    }

    @GetMapping("/detail/{id}")
    public String goDetail(@PathVariable Long id, Model model){
        model.addAttribute("flower", productService.findById(id));
        return "/products/detail";
    }

    @GetMapping("/cart")
    public String goCart(){
        return "redirect:/cart";
    }


}
