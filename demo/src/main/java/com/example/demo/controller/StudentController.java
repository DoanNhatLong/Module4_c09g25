package com.example.demo.controller;

import com.example.demo.service.IStudentService;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    IStudentService studentService;

    @GetMapping()
    public String showList(Model model) {
        model.addAttribute("mess", "test 2");
        model.addAttribute("studentList", studentService.findAll());
        return "students/list";
    }

    @GetMapping("save")
    public String getCheck(@RequestParam("class") String [] classes) {
        System.out.println(Arrays.toString(classes));
        System.out.println(classes[1]);
        return "students/list";
    }
}
