package com.example.outsourcingproject.smallstores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StoreService {

    private final StoreRepository storeRepository;

    @Autowired
    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Store createStore(StoreRequestDto storeRequestDto) {
        // 가게 정보로 새로운 Store 객체 생성
        Store store = new Store(
            storeRequestDto.getMinimumPurchase(),
            storeRequestDto.getOpensAt(),
            storeRequestDto.getClosesAt()
        );

        // 가게 저장
        return storeRepository.save(store);
    }
}
