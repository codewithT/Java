package com.ims.InventoryManagementSystem.Controller;

import com.ims.InventoryManagementSystem.Dto.ProductDto;
import com.ims.InventoryManagementSystem.Dto.ProductUpdateDto;
import com.ims.InventoryManagementSystem.Service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/IMS/product")
public class ProductController {

    @Autowired
    public ProductService productService;


    @PostMapping("/createProduct")
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        ProductDto productDto1 = productService.createProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto1);
    }


    @PutMapping("/{id}/updateProduct")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateDto productUpdateDto){
        ProductDto productDto1 = productService.updateProduct(id, productUpdateDto);
        return ResponseEntity.ok(productDto1);
    }

    @GetMapping("/allProducts")
    public ResponseEntity<Page<ProductDto>> getListOfAllProducts(@RequestParam(required = false) String search,
                                                                 @RequestParam(defaultValue = "0") int page,
                                                                 @RequestParam(defaultValue = "10") int size){

        Pageable pageable = PageRequest.of(page, size);

        return  ResponseEntity.ok(productService.listOfProducts( search, pageable));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product has been deleted successfully " + id);
    }

}
