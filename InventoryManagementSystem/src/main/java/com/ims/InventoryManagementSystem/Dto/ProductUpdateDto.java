package com.ims.InventoryManagementSystem.Dto;

public class ProductUpdateDto {
    private String name;
    private Double price;
    private Integer quantity;
    private Boolean active;

    public ProductUpdateDto(String name, Double price, Integer quantity, Boolean active) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
