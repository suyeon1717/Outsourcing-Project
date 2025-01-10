package com.example.outsourcingproject.store.dto.request;

import java.time.LocalTime;
import lombok.Getter;

@Getter
public class UpdateStoreRequestDto {
    private final String storeName;
    private final String address;
    private final String storeTelephone;
    private final Integer minimumPurchase;
    private final LocalTime opensAt;
    private final LocalTime closesAt;

    public UpdateStoreRequestDto(
        String storeName,
        String address,
        String storeTelephone,
        Integer minimumPurchase,
        LocalTime opensAt,
        LocalTime closesAt) {

        this.storeName = storeName;
        this.address = address;
        this.storeTelephone = storeTelephone;
        this.minimumPurchase = minimumPurchase;
        this.opensAt = opensAt;
        this.closesAt = closesAt;
    }
}
