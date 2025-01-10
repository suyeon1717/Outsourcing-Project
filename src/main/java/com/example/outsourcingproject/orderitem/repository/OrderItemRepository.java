package com.example.outsourcingproject.orderitem.repository;

import com.example.outsourcingproject.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
