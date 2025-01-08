package com.example.outsourcingproject.order.repository;

import com.example.outsourcingproject.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
