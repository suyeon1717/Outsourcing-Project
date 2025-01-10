package com.example.outsourcingproject.smallstores;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/stores")
public class StoreController {

        private final StoreService storeService;

        // 가게 생성 API
        @PostMapping
        public ResponseEntity<String> createStore(@RequestBody StoreRequestDto storeRequestDto) {
            storeService.createStore(storeRequestDto);
            return ResponseEntity.ok("Store created successfully");
        }
    }


