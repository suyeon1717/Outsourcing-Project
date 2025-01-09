package com.example.outsourcingproject.menu.service;

import com.example.outsourcingproject.menu.dto.request.CreateMenuRequestDto;
import com.example.outsourcingproject.menu.dto.response.CreateMenuResponseDto;

public interface MenuService {

    CreateMenuResponseDto createMenu(
        Long storeId,
        CreateMenuRequestDto requestDto
    );
}
