package com.ims.InventoryManagementSystem.Mapper;


import com.ims.InventoryManagementSystem.Dto.OrderDto;
import com.ims.InventoryManagementSystem.Dto.OrderItemDto;
import com.ims.InventoryManagementSystem.Entity.Order;
import com.ims.InventoryManagementSystem.Entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {
    public static  OrderDto mapToOrderDto(Order order){
        List<OrderItemDto> orderItemDtos = new ArrayList<>();
        for(OrderItem e: order.getItems()){
            orderItemDtos.add(OrderItemDtoMapper.mapToDTO(e));
        }
        return new OrderDto(
                order.getId(),
                order.getTotalPrice(),
                order.getCreatedAt(),
                orderItemDtos
        );
    }
    public static Order mapToOrder(OrderDto orderDto){
        List<OrderItem> orderList = new ArrayList<>();
        for(OrderItemDto e: orderDto.getItems()){
            orderList.add(OrderItemDtoMapper.mapToNonDto(e));
        }
        return new Order(
                orderDto.getId(),
                orderDto.getTotalPrice(),
                orderDto.getCreatedAt(),
                orderList
        );
    }
}
