package com.ims.InventoryManagementSystem.Dto;


import com.ims.InventoryManagementSystem.Entity.OrderItem;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDto {
    private Long id;

    private Double totalPrice;

    private LocalDateTime createdAt = LocalDateTime.now();

    private List<OrderItemDto> items;

    public OrderDto(Long id, Double totalPrice, LocalDateTime createdAt, List<OrderItemDto> items) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
        this.items = items;
    }

    public OrderDto() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }
}
