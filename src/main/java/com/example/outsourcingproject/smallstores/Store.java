package com.example.outsourcingproject.smallstores;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalTime;
import lombok.Getter;
import org.hibernate.annotations.Comment;

@Entity
@Getter
@Table(name = "STORES")
public class Store {

    @Comment("가게 식별자")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    private Long id;

    @Column(
        name = "minimum_purchase",
        nullable = false
    )
    private Integer minimumPurchase;

    @Column(
        name = "opens_at",
        nullable = false
    )
    private LocalTime opensAt;

    @Column(
        name = "closes_at",
        nullable = false
    )
    private LocalTime closesAt;

    protected Store() {
    }

    public Store(Integer minimumPurchase, LocalTime opensAt, LocalTime closesAt
    ) {
        this.minimumPurchase = minimumPurchase;
        this.opensAt = opensAt;
        this.closesAt = closesAt;
    }
}
