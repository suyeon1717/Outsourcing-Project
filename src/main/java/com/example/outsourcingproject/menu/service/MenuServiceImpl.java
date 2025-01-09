package com.example.outsourcingproject.menu.service;

import com.example.outsourcingproject.Menu;
import com.example.outsourcingproject.menu.dto.request.CreateMenuRequestDto;
import com.example.outsourcingproject.menu.dto.response.CreateMenuResponseDto;
import com.example.outsourcingproject.menu.repository.MenuRepository;
import com.example.outsourcingproject.smallstores.Store;
import com.example.outsourcingproject.smallstores.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final StoreRepository storeRepository;

    @Transactional
    @Override
    public CreateMenuResponseDto createMenu(
        Long storeId,
        CreateMenuRequestDto requestDto
    ) {
        Store foundStore = storeRepository.findById(storeId)
            .orElseThrow(
                () -> new ResponseStatusException(HttpStatus.BAD_REQUEST)
            ); // todo 가게 식별자로 가게를 조회했을 때 가게가 없으면 예외 처리

        Menu menuToSave = new Menu(
            requestDto.getMenuName(),
            requestDto.getMenuPrice(),
            requestDto.getMenuInfo(),
            foundStore
        );

        Menu savedMenu = menuRepository.save(menuToSave);

        return new CreateMenuResponseDto(
            savedMenu.getId(),
            savedMenu.getMenuName(),
            savedMenu.getMenuPrice(),
            savedMenu.getMenuInfo()
        );
    }
}
