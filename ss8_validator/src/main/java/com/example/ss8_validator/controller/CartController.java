package com.example.ss8_validator.controller;

import com.example.ss8_validator.dto.Cart;
import com.example.ss8_validator.entity.Product;
import com.example.ss8_validator.repository.IProductRepository;
import com.example.ss8_validator.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {
    @Autowired
    IProductService productService;

    @ModelAttribute ("cart")
    public Cart initCart(){
        return new Cart();
    }
    @GetMapping
    public String viewCart() {
        return "cart";
    }

    @GetMapping("/add/{id}")
    public String add(@PathVariable Long id,
                      @ModelAttribute("cart") Cart cart) {

        Product product = productService.findById(id);
        cart.add(product);

        return "redirect:/cart";
    }

    @PostMapping("/update")
    public String update(@RequestParam Integer id,
                         @RequestParam int quantity,
                         @ModelAttribute("cart") Cart cart) {

        cart.update(id, quantity);
        return "redirect:/cart";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable Integer id,
                         @ModelAttribute("cart") Cart cart) {

        cart.remove(id);
        return "redirect:/cart";
    }

    @GetMapping("/checkout")
    public String checkout(@SessionAttribute("cart") Cart cart, Model model) {
        model.addAttribute("total", cart.getTotal());
        return "products/checkout";
    }


}
