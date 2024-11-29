package com.ims.InventoryManagementSystem.Dto;

import com.ims.InventoryManagementSystem.Entity.Product;

public class OrderItemDto {

    private Long id;
    private ProductDto productDto;
    private Integer quantity;
    private Double price;

    public OrderItemDto(Long id,ProductDto productDto, Integer quantity, Double price) {
        this.id = id;
        this.quantity = quantity;
        this.productDto = productDto;
        this.price = price;
    }

    public OrderItemDto() {

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductDto getProductDto() {
        return productDto;
    }

    public void setProductDto(ProductDto productDto) {
        this.productDto = productDto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
