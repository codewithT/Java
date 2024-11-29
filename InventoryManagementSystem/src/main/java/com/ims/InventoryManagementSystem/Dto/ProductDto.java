package com.ims.InventoryManagementSystem.Dto;


public class ProductDto {

    Long id;
    private String sku;
    private String name;
    private Double price;
    private Integer quantity;
    private Boolean active = true;

    public ProductDto( Long id ,String sku, String name, Double price, Integer quantity, Boolean active) {
        this.sku = sku;
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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
