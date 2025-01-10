package com.example.outsourcingproject.store.controller;

import com.example.outsourcingproject.store.dto.request.CreateStoreRequestDto;
import com.example.outsourcingproject.store.dto.request.UpdateStoreRequestDto;
import com.example.outsourcingproject.store.dto.response.CreateStoreResponseDto;
import com.example.outsourcingproject.store.dto.response.StoreNameResponseDto;
import com.example.outsourcingproject.store.dto.response.StoreResponseDto;
import com.example.outsourcingproject.store.dto.response.UpdateStoreResponseDto;
import com.example.outsourcingproject.store.repository.StoreRepository;
import com.example.outsourcingproject.store.service.StoreService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;
    private final StoreRepository storeRepository;

    // 가게 생성
    @PostMapping
    public ResponseEntity<CreateStoreResponseDto> createStore(
        @RequestBody CreateStoreRequestDto requestDto,
        @RequestHeader("Authorization") String token) { //todo @Valid 유효성 검사

        CreateStoreResponseDto createStoreResponseDto = storeService.createStore(
            requestDto,
            token
        );

        return new ResponseEntity<>(createStoreResponseDto, HttpStatus.CREATED);
    }

    // 가게 다건 조회 : entity에서 dto로 변환
    @GetMapping
    public ResponseEntity<List<StoreNameResponseDto>> findAllStore(
        @RequestParam String search
    ) {
        List<StoreNameResponseDto> storeResponseDtoList = storeService.findByStoreNameContaining(search);
        log.info("findAllStore:{}", storeResponseDtoList);
        return new ResponseEntity<>(storeResponseDtoList, HttpStatus.OK);
    }

    // 가게 단건 조회
    @GetMapping("/{storeId}")
    public ResponseEntity<StoreResponseDto> findByStoreId(
        @PathVariable Long storeId
    ) {
        StoreResponseDto storeResponseDto = storeService.findByStoreId(storeId);
        log.info(storeResponseDto.getStoreName());
        return new ResponseEntity<>(storeResponseDto, HttpStatus.OK);
    }

    // 가게 수정
    @PatchMapping("/stores/{storeId}")
    public ResponseEntity<UpdateStoreResponseDto> updateStore(
        @PathVariable Long storeId,
        @RequestBody UpdateStoreRequestDto requestDto
    ) {

        UpdateStoreResponseDto storeResponseDto = storeService.updateStore(storeId,requestDto);

        return new ResponseEntity<>(storeResponseDto, HttpStatus.OK);
    }

//
//    // 가게 폐업 : 소프트딜리트
//    @DeleteMapping
//    public ResponseEntity<Void> deleteStore(
//        @PathVariable Long storeId
//        //todo 폐업시 비밀번호 확인?
//    ){
//        storeService.deleteStore(storeId);
//
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }


}

