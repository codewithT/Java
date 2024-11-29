package com.ims.InventoryManagementSystem.Service;

import com.ims.InventoryManagementSystem.Dto.OrderDto;
import com.ims.InventoryManagementSystem.Dto.RequestsDTO.OrderRequestDto;
import org.springframework.data.domain.Page;

public interface OrderService {
        OrderDto createOrder(OrderRequestDto orderRequestDto);
        OrderDto getOrderDetails(Long id);
        Page<OrderDto> listAllOrders(int page, int size);

}
