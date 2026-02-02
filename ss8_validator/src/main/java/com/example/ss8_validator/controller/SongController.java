package com.example.ss8_validator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SongController {
    @GetMapping("/song")
    public String song() {
        return "songs/list";
    }
}
