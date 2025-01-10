package com.example.outsourcingproject.smallstores;

import java.time.LocalTime;
import lombok.Getter;

@Getter
public class StoreRequestDto {

    private final Integer minimumPurchase;
    private final LocalTime opensAt;
    private final LocalTime closesAt;

    public StoreRequestDto(Integer minimumPurchase, LocalTime opensAt, LocalTime closesAt) {
        this.minimumPurchase = minimumPurchase;
        this.opensAt = opensAt;
        this.closesAt = closesAt;
    }
}
