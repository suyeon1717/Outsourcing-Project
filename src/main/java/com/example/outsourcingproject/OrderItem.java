package com.example.outsourcingproject;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "ORDER_ITEMS")
@Getter
public class OrderItem {

  @Comment("주문 아이템 식별자")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(columnDefinition = "BIGINT")
  private Long id;

  @Comment("주문한 메뉴의 각 수량")
  @Column(
      name = "each_amount",
      nullable = false
  )
  private Long eachAmount;

  @Comment("주문한 메뉴의 각 가격")
  @Column(
      name = "each_price",
      nullable = false
  )
  private Long eachPrice;

  @Comment("주문한 메뉴의 총 수량")
  @Column(
      name = "total_amount",
      nullable = false
  )
  private Long totalAmount;

  @Comment("주문한 메뉴의 총 가격")
  @Column(
      name = "total_price",
      nullable = false
  )
  private Long totalPrice;

  protected OrderItem() {
  }
}