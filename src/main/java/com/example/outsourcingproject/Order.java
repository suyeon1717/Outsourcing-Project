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

  protected Order() {
  }

  public Order(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }
}