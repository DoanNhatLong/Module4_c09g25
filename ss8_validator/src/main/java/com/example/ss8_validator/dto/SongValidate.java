package com.example.ss8_validator.dto;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SongValidate implements Validator {
    private static final String NAME_REGEX = "^[a-zA-Z0-9 ,\\-]+$";

    @Override
    public boolean supports(Class<?> clazz) {
        return SongDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;

        validateName(songDto, errors);
        validateSinger(songDto, errors);
        validateType(songDto, errors);
    }

    private void validateName(SongDto songDto, Errors errors) {
        String name = songDto.getName();

        if (name == null || name.trim().isEmpty()) {
            errors.rejectValue("name", null,
                    "Trường không được để trống");
            return;
        }

        if (name.length() > 40) {
            errors.rejectValue("name", null,
                    "Tên bài hát không được vượt quá 40 ký tự");
            return;
        }

        if (!name.matches(NAME_REGEX)) {
            errors.rejectValue("name", null,
                    "Tên bài hát chỉ được chứa chữ, số, khoảng trắng, '-' và ','");
        }
    }

    private void validateSinger(SongDto songDto, Errors errors) {
        String singer = songDto.getSinger();

        if (singer == null || singer.trim().isEmpty()) {
            errors.rejectValue("singer", null,
                    "Trường không được để trống");
        }
    }

    private void validateType(SongDto songDto, Errors errors) {
        String type = songDto.getType();

        if (type == null || type.trim().isEmpty()) {
            errors.rejectValue("type", null,
                    "Trường không được để trống");
        }
    }
}