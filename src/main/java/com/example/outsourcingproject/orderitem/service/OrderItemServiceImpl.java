package com.example.outsourcingproject.orderitem.service;

import com.example.outsourcingproject.Order;
import com.example.outsourcingproject.OrderItem;
import com.example.outsourcingproject.OrderItemWrapper;
import com.example.outsourcingproject.OrderStatus;
import com.example.outsourcingproject.order.repository.OrderRepository;
import com.example.outsourcingproject.orderitem.dto.request.CreateOrderItemRequestDto;
import com.example.outsourcingproject.orderitem.dto.response.CreateOrderItemResponseDto;
import com.example.outsourcingproject.orderitem.repository.OrderItemRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderItemServiceImpl implements OrderItemService {

  private final OrderItemRepository orderItemRepository;
  private final OrderRepository orderRepository;

  public OrderItemServiceImpl(
      OrderItemRepository orderItemRepository,
      OrderRepository orderRepository
  ) {
    this.orderItemRepository = orderItemRepository;
    this.orderRepository = orderRepository;
  }

  @Transactional
  @Override
  public OrderItemWrapper createOrderItem(
      List<CreateOrderItemRequestDto> requestDtoList
  ) {

    Order orderToSave = new Order(OrderStatus.PENDING);
    Order savedOrder = orderRepository.save(orderToSave);

    List<CreateOrderItemResponseDto> responseDtoList = new ArrayList<>();

    responseDtoList = requestDtoList.stream()
        .map(requestDto -> {
              OrderItem orderItemToSave = new OrderItem(
                  savedOrder,
                  requestDto.getMenuId(),
                  requestDto.getEachAmount(),
                  requestDto.getEachPrice()
              );

              OrderItem savedOrderItem = orderItemRepository.save(orderItemToSave);

              return new CreateOrderItemResponseDto(
                  savedOrderItem.getId(),
                  savedOrderItem.getMenuId(),
                  savedOrderItem.getEachAmount(),
                  savedOrderItem.getEachPrice(),
                  savedOrderItem.getTotalPrice()
              );
            }
        ).toList();

    Integer totalAmountSum = responseDtoList.stream()
        .mapToInt(CreateOrderItemResponseDto::getEachAmount)
        .sum();

    Integer totalPriceSum = responseDtoList.stream()
        .mapToInt(CreateOrderItemResponseDto::getTotalPrice)
        .sum();

    return new OrderItemWrapper(
        responseDtoList,
        totalAmountSum,
        totalPriceSum,
        savedOrder.getId()
    );
  }
}