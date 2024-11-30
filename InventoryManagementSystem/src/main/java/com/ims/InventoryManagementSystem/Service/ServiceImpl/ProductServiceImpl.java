package com.ims.InventoryManagementSystem.Service.ServiceImpl;

import com.ims.InventoryManagementSystem.Dto.ProductDto;
import com.ims.InventoryManagementSystem.Dto.ProductUpdateDto;
import com.ims.InventoryManagementSystem.Entity.Product;
import com.ims.InventoryManagementSystem.Exception.ProductNotAvailableException;
import com.ims.InventoryManagementSystem.Exception.UniqueSkuException;
import com.ims.InventoryManagementSystem.Mapper.ProductMapper;
import com.ims.InventoryManagementSystem.Repository.ProductRepository;
import com.ims.InventoryManagementSystem.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    public ProductRepository productRepository;

    @Override
    public ProductDto createProduct(ProductDto productDto) {
        Product product = ProductMapper.mapToProduct(productDto);
        Product checkForUniqueSku = productRepository.findBySku(product.getSku());
        if(checkForUniqueSku != null){
            throw new UniqueSkuException("Please, Provide Unique SKU details", "PRODUCT_SKU_NOT_UNIQUE");
        }
        productRepository.save(product);
        ProductDto savedProduct= ProductMapper.mapToProductDto(product);
        return savedProduct;
    }

    @Override
    public ProductDto updateProduct(Long id, ProductUpdateDto productUpdateDto) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new ProductNotAvailableException("Please select a valid product", "PRODUCT_NOT_AVALIABLE"));
        if(!productUpdateDto.getActive()){
            throw new ProductNotAvailableException("Product out of stock" + id , "PRODUCT_NOT_AVALIBALE");
        }
        if(productUpdateDto.getName() != null){
            product.setName(productUpdateDto.getName());
        }
        if(productUpdateDto.getPrice() != null){
            product.setPrice(productUpdateDto.getPrice());
        }
        if(productUpdateDto.getQuantity() != null){
            product.setQuantity(productUpdateDto.getQuantity());
        }
        productRepository.save(product);
        return ProductMapper.mapToProductDto(product);
    }

    @Override
    public Page<ProductDto> listOfProducts(String search, Pageable pageable) {
        if(search ==  null ||  search.isEmpty()){

            Page<Product> products =  productRepository.findAll(pageable);
            List<ProductDto> productDtoList = mapToList(products);
            return new PageImpl<>(productDtoList, pageable, products.getTotalElements());
        }
        Page<Product> products = productRepository.findByNameContainingOrSkuContaining(search, search, pageable);
        List<ProductDto>  productDtoList = mapToList(products);

        return new PageImpl<>(productDtoList, pageable, products.getTotalElements());
    }

    public List<ProductDto> mapToList(Page<Product> products){
        List<ProductDto> productDtoList = new ArrayList<>();
        for(Product e: products){
            if(e.getActive()) { // dont add deleted product or inactive
                productDtoList.add(ProductMapper.mapToProductDto(e));
            }
        }
        return productDtoList;
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() ->
                new ProductNotAvailableException("Please select a valid product to delete" , "PRODUCT_NOT_AVAILABLE"));
        if(!product.getActive()){
            throw new ProductNotAvailableException("Please select a valid product to delete" , "PRODUCT_NOT_AVAILABLE");
        }
        product.setActive(false);
        productRepository.save(product);
    }

}
