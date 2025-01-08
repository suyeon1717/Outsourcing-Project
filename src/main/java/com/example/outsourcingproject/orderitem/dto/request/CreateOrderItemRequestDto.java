package com.example.outsourcingproject.orderitem.dto.request;

import lombok.Getter;

@Getter
public class CreateOrderItemRequestDto {

  private final Long menuId;
  private final Integer eachAmount;
  private final Integer eachPrice;

  public CreateOrderItemRequestDto(
      Long menuId,
      Integer eachAmount,
      Integer eachPrice
  ) {
    this.menuId = menuId;
    this.eachAmount = eachAmount;
    this.eachPrice = eachPrice;
  }
}