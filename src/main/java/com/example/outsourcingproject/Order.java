package com.example.outsourcingproject;

import com.example.outsourcingproject.temporary.Store;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

    @Comment("가게")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "store_id",
        nullable = false
    )
    private Store store;

    protected Order() {
    }

    public Order(
        OrderStatus orderStatus,
        Store store
    ) {
        this.orderStatus = orderStatus;
        this.store = store;
    }

    public void updateTotals(
        Integer totalAmountSum,
        Integer totalPriceSum
    ) {
        this.totalAmountSum = totalAmountSum;
        this.totalPriceSum = totalPriceSum;
    }
}