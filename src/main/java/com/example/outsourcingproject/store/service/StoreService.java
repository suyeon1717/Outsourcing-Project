package com.example.outsourcingproject.store.service;

import com.example.outsourcingproject.store.dto.request.CreateStoreRequestDto;
import com.example.outsourcingproject.store.dto.request.UpdateStoreRequestDto;
import com.example.outsourcingproject.store.dto.response.CreateStoreResponseDto;
import com.example.outsourcingproject.store.dto.response.StoreNameResponseDto;
import com.example.outsourcingproject.store.dto.response.StoreResponseDto;
import com.example.outsourcingproject.store.dto.response.UpdateStoreResponseDto;
import java.util.List;

public interface StoreService {

   CreateStoreResponseDto createStore(
       CreateStoreRequestDto requestDto,
       String token
   );

   List<StoreNameResponseDto> findByStoreNameContaining(String storeName);

   StoreResponseDto findByStoreId(Long storeId);

   UpdateStoreResponseDto updateStore(
       Long id,
       UpdateStoreRequestDto requestDto
   );
}


//
//   void deleteStore(Long storeId);
//}
//
