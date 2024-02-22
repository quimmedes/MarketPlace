package com.api.marketplace.repository;

import com.api.marketplace.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {

    List<Store> findByName(String name);
}
