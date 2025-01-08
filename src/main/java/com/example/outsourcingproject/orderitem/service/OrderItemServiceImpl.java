package com.example.outsourcingproject.orderitem.service;

import com.example.outsourcingproject.Order;
import com.example.outsourcingproject.OrderItem;
import com.example.outsourcingproject.OrderItemWrapper;
import com.example.outsourcingproject.OrderStatus;
import com.example.outsourcingproject.order.repository.OrderRepository;
import com.example.outsourcingproject.orderitem.dto.request.CreateOrderItemRequestDto;
import com.example.outsourcingproject.orderitem.dto.response.CreateOrderItemResponseDto;
import com.example.outsourcingproject.orderitem.repository.OrderItemRepository;
import com.example.outsourcingproject.temporary.Menu;
import com.example.outsourcingproject.temporary.MenuRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrderItemServiceImpl implements OrderItemService {

  private final OrderItemRepository orderItemRepository;
  private final OrderRepository orderRepository;
  private final MenuRepository menuRepository;

  public OrderItemServiceImpl(
      OrderItemRepository orderItemRepository,
      OrderRepository orderRepository,
      MenuRepository menuRepository
  ) {
    this.orderItemRepository = orderItemRepository;
    this.orderRepository = orderRepository;
    this.menuRepository = menuRepository;
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

              Menu foundMenu = menuRepository.findById(requestDto.getMenuId())
                  .orElseThrow(
                      () -> new ResponseStatusException(
                          HttpStatus.NOT_FOUND
                      )
                  ); // todo

              OrderItem orderItemToSave = new OrderItem(
                  savedOrder,
                  foundMenu,
                  requestDto.getEachAmount()
              );

              OrderItem savedOrderItem = orderItemRepository.save(orderItemToSave);

              return new CreateOrderItemResponseDto(
                  savedOrderItem.getId(),
                  foundMenu.getId(),
                  savedOrderItem.getEachAmount(),
                  foundMenu.getPrice(),
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