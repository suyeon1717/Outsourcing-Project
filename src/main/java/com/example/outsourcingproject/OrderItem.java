package com.example.outsourcingproject;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
  private Integer eachAmount;

  @Comment("주문한 메뉴의 각 가격")
  @Column(
      name = "each_price",
      nullable = false
  )
  private Integer eachPrice;

  @Comment("주문한 메뉴의 총 가격")
  @Column(
      name = "total_price",
      nullable = false
  )
  private Integer totalPrice;

  // todo 메뉴 Id 추후 연관관계 설정 해야 함)
  @Comment("메뉴 식별자")
  @Column(
      name = "menu_id",
      nullable = false
  )
  private Long menuId;

  @Comment("주문 식별자")
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

  protected OrderItem() {
  }

  public OrderItem(
      Order order,
      Long menuId,
      Integer eachAmount,
      Integer eachPrice
  ) {
    this.order = order;
    this.menuId = menuId;
    this.eachAmount = eachAmount;
    this.eachPrice = eachPrice;
    this.totalPrice = calculateTotalPrice(eachAmount, eachPrice);
  }

  private Integer calculateTotalPrice(
      Integer eachAmount,
      Integer eachPrice
  ) {
    return eachPrice * eachAmount;
  }
}