package com.api.marketplace.repository;

import com.api.marketplace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    
    List<Product> findByNameOrderByPriceAsc(String name);

    List<Product> findByStoreId(Long storeId);

    
}
