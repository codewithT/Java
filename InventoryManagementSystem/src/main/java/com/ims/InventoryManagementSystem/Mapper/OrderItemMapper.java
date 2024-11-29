package com.ims.InventoryManagementSystem.Mapper;

import com.ims.InventoryManagementSystem.Dto.OrderItemDto;
import com.ims.InventoryManagementSystem.Dto.ProductDto;

public class OrderItemMapper {

    public static OrderItemDto mapToOrderItemDto(ProductDto productDto , Integer quantity){
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setProductDto(productDto);
        orderItemDto.setQuantity(quantity);
        orderItemDto.setPrice(productDto.getPrice());
        return orderItemDto;
    }
}
