package com.example.ss8_validator.controller;

import com.example.ss8_validator.dto.UserDto;
import com.example.ss8_validator.entity.User;
import com.example.ss8_validator.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ValidateController {
    @Autowired
    private IUserService userService;


    @GetMapping("/validate")
    public String validate(@ModelAttribute UserDto userDto) {
        return "validator";
    }

    @GetMapping("/validate/add")
    public String add(
            @Valid @ModelAttribute UserDto userDto,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {
        User user = new User();
        new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "validator";
        }
        BeanUtils.copyProperties(userDto, user);
        boolean flag = userService.save(user);
        redirectAttributes.addFlashAttribute("message",
                flag ? "Thêm mới thành công" : "Thêm mới thất bại");
        return "redirect:/validate";
    }
}
