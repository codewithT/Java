package com.ims.InventoryManagementSystem.Service.ServiceImpl;

import com.ims.InventoryManagementSystem.Dto.*;
import com.ims.InventoryManagementSystem.Dto.RequestsDTO.IdAndQuantity;
import com.ims.InventoryManagementSystem.Dto.RequestsDTO.OrderRequestDto;
import com.ims.InventoryManagementSystem.Entity.Order;
import com.ims.InventoryManagementSystem.Entity.Product;
import com.ims.InventoryManagementSystem.Exception.NoOrdersExceptioin;
import com.ims.InventoryManagementSystem.Exception.OrderNotFoundException;
import com.ims.InventoryManagementSystem.Exception.ProductNotAvailableException;
import com.ims.InventoryManagementSystem.Mapper.OrderItemMapper;
import com.ims.InventoryManagementSystem.Mapper.OrderMapper;
import com.ims.InventoryManagementSystem.Mapper.ProductMapper;
import com.ims.InventoryManagementSystem.Repository.OrderRepository;
import com.ims.InventoryManagementSystem.Repository.ProductRepository;
import com.ims.InventoryManagementSystem.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    public OrderRepository orderRepository;
    @Autowired
    public ProductRepository productRepository;

    @Override
    public OrderDto createOrder(OrderRequestDto orderRequestDto) {
       Map<Long, Integer> idAndQuantityList = new HashMap<>();

        for(IdAndQuantity e: orderRequestDto.getProductIds()){
            idAndQuantityList.put(e.getProductId(), e.getQuantity());
        }

        List<OrderItemDto> orderItemsList = new ArrayList<>();
        double totalPrice = 0.0;
        for( Map.Entry<Long, Integer> e: idAndQuantityList.entrySet()){
            Long productId = e.getKey();
            Integer quantity = e.getValue();
            Product product= productRepository.findById(productId).orElseThrow(()->new RuntimeException("Product not found " + productId));

            if (!product.getActive()) {
                throw new ProductNotAvailableException("Product is not available for purchase: " + product.getName(),"PRODUCT_NOT_AVAILABLE");
            }

            OrderItemDto orderItemDto = OrderItemMapper.mapToOrderItemDto(ProductMapper.mapToProductDto(product), quantity);
            product.setQuantity(product.getQuantity() - orderItemDto.getQuantity());
            orderItemsList.add(orderItemDto);
            totalPrice += product.getPrice() * quantity;
        }
        OrderDto orderDto = new OrderDto();
        orderDto.setTotalPrice(totalPrice);
        orderDto.setCreatedAt(LocalDateTime.now());
        orderDto.setItems(orderItemsList);
        Order savedOrder =orderRepository.save(OrderMapper.mapToOrder(orderDto));

        return OrderMapper.mapToOrderDto(savedOrder);
    }

    @Override
    public OrderDto getOrderDetails(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(()->new OrderNotFoundException("Order not found. Please create an order", "ORDER_NOT_FOUND"));

        return OrderMapper.mapToOrderDto(order);
    }

    @Override
    public Page<OrderDto> listAllOrders(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Order> ordersPage =  orderRepository.findAll(pageable);
        List<OrderDto> orderDtoList = mapToList(ordersPage);
        if(orderDtoList.size() == 0){
            throw new NoOrdersExceptioin("No orders made until now. Please select a product to Order." , "ORDERS_NOT_CREATED");
        }
        return new PageImpl<>(orderDtoList, pageable, ordersPage.getTotalElements());
    }

    public List<OrderDto> mapToList (Page<Order> orders){
        List<OrderDto> orderDtoList = new ArrayList<>();
        for(Order e: orders){
            orderDtoList.add(OrderMapper.mapToOrderDto(e));
        }
        return orderDtoList;
    }

}
