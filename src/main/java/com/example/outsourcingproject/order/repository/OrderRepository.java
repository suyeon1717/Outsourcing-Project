package com.example.outsourcingproject.order.repository;

import com.example.outsourcingproject.Order;
import com.example.outsourcingproject.OrderStatus;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Order> findByIdAndOrderStatusNot(
        Long id,
        OrderStatus status
    );

}
