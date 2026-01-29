package com.example.ss7_spring_data.service;

import com.example.ss7_spring_data.dto.ViewDto;

import java.util.List;

public interface IBlogService {
    List<ViewDto> findAllView();
    boolean delete(int id);
}
