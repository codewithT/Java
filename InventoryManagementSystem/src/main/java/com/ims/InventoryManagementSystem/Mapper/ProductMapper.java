package com.ims.InventoryManagementSystem.Mapper;

import com.ims.InventoryManagementSystem.Dto.ProductDto;
import com.ims.InventoryManagementSystem.Entity.Product;
import com.ims.InventoryManagementSystem.Service.ProductService;

public class ProductMapper {
    public static Product mapToProduct(ProductDto productDto){
        return new Product(
                productDto.getId(),
                productDto.getSku(),
                productDto.getName(),
                productDto.getPrice(),
                productDto.getQuantity(),
                productDto.getActive()
        );
    }
    public static ProductDto mapToProductDto(Product product){
        return new ProductDto(
                product.getId(),
                product.getSku(),
                product.getName(),
                product.getPrice(),
                product.getQuantity(),
                product.getActive()
        );
    }
}
