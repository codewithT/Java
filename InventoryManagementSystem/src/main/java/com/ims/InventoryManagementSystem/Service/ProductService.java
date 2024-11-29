package com.ims.InventoryManagementSystem.Service;

import com.ims.InventoryManagementSystem.Dto.ProductDto;
import com.ims.InventoryManagementSystem.Dto.ProductUpdateDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface ProductService {
    ProductDto createProduct(ProductDto productDto);
    ProductDto updateProduct(Long id, ProductUpdateDto productUpdateDto);
    Page<ProductDto> listOfProducts(String search, Pageable pageable);
    void deleteProduct(Long id);
}
