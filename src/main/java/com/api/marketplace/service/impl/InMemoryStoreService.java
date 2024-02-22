package com.api.marketplace.service.impl;

import com.api.marketplace.dto.StoreDto;
import com.api.marketplace.model.Store;
import com.api.marketplace.repository.StoreRepository;
import com.api.marketplace.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of {@link StoreService} that saves stores in memory.
 */
@Service
public class InMemoryStoreService implements StoreService {

    private final StoreRepository storeRepository;

    public InMemoryStoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public StoreDto createStore(StoreDto store) {
        Store createdStore = storeRepository.save(store.toEntity());
        return StoreDto.of(createdStore);
    }

    @Override
    public Optional<StoreDto> getStore(Long storeId) {
        return storeRepository.findById(storeId)
                              .map(StoreDto::of);
    }

    @Override
    public List<StoreDto> findStoreByName(String storeName) {
        return storeRepository.findByName(storeName)
                              .stream()
                              .map(StoreDto::of)
                              .collect(Collectors.toList());
    }
}
