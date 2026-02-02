package com.example.ss8_validator.controller;

import com.example.ss8_validator.dto.SongDto;
import com.example.ss8_validator.dto.SongValidate;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    SongValidate songValidate;

    @GetMapping("")
    public String song() {
        return "/songs/list";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("songDto", new SongDto());
        return "/songs/form_add";
    }

    @PostMapping("/add")
    public String sava(
            @Valid @ModelAttribute SongDto songDto,
            BindingResult bindingResult
    ){
        songValidate.validate(songDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "/songs/form_add";
        } else {
            System.out.println(songDto.getName());
        }
        return "redirect:/song";
    }
}
