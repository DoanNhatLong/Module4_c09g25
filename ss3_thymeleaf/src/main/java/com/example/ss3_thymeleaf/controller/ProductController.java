package com.example.ss3_thymeleaf.controller;

import com.example.ss3_thymeleaf.entity.Product;
import com.example.ss3_thymeleaf.service.IProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/home")
@Controller
public class ProductController {
    @Autowired
    private IProductService productService;

    @ModelAttribute
    public void commonData(HttpSession session, Model model){
        session.setAttribute("type", List.of("Điện tử", "Gia dụng", "Nội thất"));
        model.addAttribute("products",productService.findAll());
    }

    @GetMapping()
    public String goHome(){
        return "/home";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam ("id") int id, RedirectAttributes redirectAttributes){
        boolean flag =  productService.deleteByID(id);
        redirectAttributes.addFlashAttribute("message",
                flag ? "Xóa thành công" : "Xóa thất bại"
        );
        return "redirect:/home";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("product", new Product());

        return "products/add";
    }

    @GetMapping("/save")
    public String save(@ ModelAttribute Product product, RedirectAttributes redirectAttributes){
        productService.add(product);
        redirectAttributes.addFlashAttribute("message",
                "Thêm mới thành công"
        );
        return "redirect:/home";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam("id") int id, Model model){
        Product product=productService.findByID(id);
        model.addAttribute("product",product);
        return "products/detail";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam("id") int id, Model model){
        Product product=productService.findByID(id);
        model.addAttribute("product",product);
        return "products/edit";
    }
}
