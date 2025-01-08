package com.example.outsourcingproject;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "ORDERS")
@Getter
public class Order extends BaseEntity {

  @Comment("주문 식별자")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(columnDefinition = "BIGINT")
  private Long id;

  @Comment("주문 상태")
  @Enumerated(EnumType.STRING)
  @Column(
      name = "order_status",
      nullable = false
  )
  private OrderStatus orderStatus;

  @Comment("주문 총 수량")
  @Column(
      name = "total_amount_sum",
      nullable = false
  )
  private Integer totalAmountSum = 0;

  @Comment("주문 총가격")
  @Column(
      name = "total_price_sum",
      nullable = false
  )
  private Integer totalPriceSum = 0;

  protected Order() {
  }

  public Order(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }

  public void updateTotals(
      Integer totalAmountSum,
      Integer totalPriceSum
  ) {
    this.totalAmountSum = totalAmountSum;
    this.totalPriceSum = totalPriceSum;
  }
}