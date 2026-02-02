package com.example.ss8_validator.dto;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Getter
@Setter
@NoArgsConstructor
public class UserDto implements Validator {

    private String name;

    private String phone;

    private int age;

    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if(userDto.getName().isEmpty()){
            errors.rejectValue("name", "Name is required");
        } else if(userDto.getName().length() < 3 || userDto.getName().length() > 50){
            errors.rejectValue("name", "Name must be between 3 and 50 characters");
        }
        if(userDto.getPhone().isEmpty()){
            errors.rejectValue("phone", "Phone is required");
        } else if(!userDto.getPhone().matches("^\\d{10}$")){
            errors.rejectValue("phone", "Phone must be 10 digits");
        }
        if (userDto.getEmail().isEmpty() || userDto.getEmail().contains("@gmail.com")) {
            errors.rejectValue("email", "Email must not be gmail");
        }
        if (userDto.getAge() < 18) {
            errors.rejectValue("age", "Age must be at least 18");
        }
    }
}
