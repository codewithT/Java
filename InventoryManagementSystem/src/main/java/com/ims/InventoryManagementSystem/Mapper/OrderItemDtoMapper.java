package com.ims.InventoryManagementSystem.Mapper;

import com.ims.InventoryManagementSystem.Dto.OrderItemDto;
import com.ims.InventoryManagementSystem.Dto.ProductDto;
import com.ims.InventoryManagementSystem.Entity.OrderItem;
import com.ims.InventoryManagementSystem.Entity.Product;

public class OrderItemDtoMapper {
    public  static OrderItem mapToNonDto(OrderItemDto orderItemDto){
//        (Long id, Product product, Integer quantity, Double price
        return  new OrderItem(
                orderItemDto.getId(),
                ProductMapper.mapToProduct(orderItemDto.getProductDto()),
                orderItemDto.getQuantity(),
                orderItemDto.getPrice()
        );
    }
//    Long id, Integer quantity, ProductDto productDto, Double price
    public  static OrderItemDto mapToDTO(OrderItem orderItem){
        return new OrderItemDto(
                orderItem.getId(),
                ProductMapper.mapToProductDto(orderItem.getProduct()),
                orderItem.getQuantity(),

                orderItem.getPrice()
        );
    }
}
