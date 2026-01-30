package com.example.ss7_spring_data.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchDto {
    private String tittle;
    private String content;
    private Integer idCategory;
}
