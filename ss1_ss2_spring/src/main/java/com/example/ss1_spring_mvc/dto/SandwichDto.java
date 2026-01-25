package com.example.ss1_spring_mvc.dto;

import java.util.List;

public class SandwichDto {
    private List<String> condiment;

    public List<String> getCondiment() {
        return condiment;
    }

    public void setCondiment(List<String> condiment) {
        this.condiment = condiment;
    }
}
