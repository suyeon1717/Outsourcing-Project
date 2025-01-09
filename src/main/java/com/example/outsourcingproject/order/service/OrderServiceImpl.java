package com.example.outsourcingproject.order.service;

import com.example.outsourcingproject.Order;
import com.example.outsourcingproject.OrderStatus;
import com.example.outsourcingproject.order.dto.request.UpdateOrderRequestDto;
import com.example.outsourcingproject.order.dto.response.UpdateOrderResponseDto;
import com.example.outsourcingproject.order.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional
    @Override
    public UpdateOrderResponseDto updateOrderStatus(UpdateOrderRequestDto requestDto) {
        Order foundOrder = orderRepository.findByIdAndOrderStatusNot(
            requestDto.getId(),
            OrderStatus.DELIVERED
        ).orElseThrow(
            () -> new ResponseStatusException(
                HttpStatus.NOT_FOUND
            )
        ); // todo 배달 완료 제외한 주문 조회 및 없을 시 예외 처리

        foundOrder.updateOrderStatus(
            OrderStatus.of(requestDto.getOrderStatus())
        );

        return UpdateOrderResponseDto.toDto(foundOrder);
    }
}
