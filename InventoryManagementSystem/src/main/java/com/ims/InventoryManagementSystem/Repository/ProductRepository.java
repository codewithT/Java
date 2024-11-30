package com.ims.InventoryManagementSystem.Repository;

import com.ims.InventoryManagementSystem.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findByNameContainingOrSkuContaining(String name, String sku, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE p.sku = :sku")
    Product findBySku(@Param("sku") String sku);

}
