package com.ims.InventoryManagementSystem.Dto.RequestsDTO;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequestDto {

    private List<IdAndQuantity> productIds;
    private Double totalPrice;
    private LocalDateTime createdAt = LocalDateTime.now();

    public OrderRequestDto(List<IdAndQuantity> productIds, Double totalPrice, LocalDateTime createdAt) {
        this.productIds = productIds;
        this.totalPrice = totalPrice;
        this.createdAt = createdAt;
    }


    public List<IdAndQuantity> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<IdAndQuantity> productIds) {
        this.productIds = productIds;
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
}
