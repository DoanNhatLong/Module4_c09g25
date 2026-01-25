package com.example.ss1_spring_mvc.controller;

import com.example.ss1_spring_mvc.dto.SandwichDto;
import com.example.ss1_spring_mvc.entity.Email;
import com.example.ss1_spring_mvc.service.ITransService;
import jakarta.servlet.http.HttpSession;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/home")
@Controller
public class HomeController {
    @Autowired
    private ITransService transService;

    @GetMapping()
    public String goHome(HttpSession session) {
        session.setAttribute("language", List.of("Englist", "Vietnam", "Japan", "Chinese"));
        return "/home";
    }

    @GetMapping("/calc")
    public String calculation(@RequestParam(required = false, name = "money") Integer money, Model model) {
        if (money != null) {
            model.addAttribute("result", money * 22000);
        }
        return "/calc";
    }

    @GetMapping("trans")
    public String translate(@RequestParam(required = false, name = "word") String word, Model model) {
        String temp = transService.findWord(word);
        model.addAttribute("result",
                temp != null ? temp : "Không tìm thấy từ");
        return "/trans";
    }

    @GetMapping("/sandwich")
    public String choose(
            @ModelAttribute("sandwichDto") SandwichDto sandwichDto,
            Model model) {
        model.addAttribute("result", sandwichDto.getCondiment());
        return "/sandwich";
    }

    @GetMapping("/computer")
    public String computer(
            @RequestParam(required = false, name = "a") Double a,
            @RequestParam(required = false, name = "b") Double b,
            @RequestParam(required = false, name = "op") String op,
            Model model) {
        double result = 0;
        if (a != null && b != null && op != null) {
            result = switch (op) {
                case "+" -> a + b;
                case "-" -> a - b;
                case "*" -> a * b;
                case "/" -> b != 0 ? a / b : 0;
                default -> 0;
            };
        }
        model.addAttribute("result", result);
        return "/computer";
    }

    @GetMapping("/email")
    public String goFormEmail(Model model) {
        model.addAttribute("email", new Email());
        return "/email";
    }

    @PostMapping("/email")
    public String showEmail(
            @ModelAttribute("email") Email email
    ) {
        System.out.println(email);
        return "/info";
    }
}
