package com.api.marketplace.service.impl;

import com.api.marketplace.dto.ProductDto;
import com.api.marketplace.repository.ProductRepository;
import com.api.marketplace.service.ProductService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of {@link ProductService} that stores products in memory.
 */
@Service
public class InMemoryProductService implements ProductService {

    /**
     * Method add new product to given store and returns info about created method.
     *
     * @param productDto    product dto that need to be created(added)
     * @param storeId       id of the store where new product need to be added
     * @return              created product dto
     */

    private ProductRepository productRepository;

    public InMemoryProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto addProduct(ProductDto productDto, Long storeId) {

            productDto.setStoreId(storeId);
            return ProductDto.of(productRepository.save(productDto.toEntity()));
        
    }

    /**
     * Method to get product by it's id
     *
     * @param productId     the Id of product that we want to get
     * @return              returns the Optional object that keeping product dto
     */
    @Override
    public Optional<ProductDto> getProduct(Long productId) {
       
        return productRepository.findById(productId)
                              .map(ProductDto::of);
    }

    /**
     * Method allows to find all products with given name
     *
     * @param productName   the name of the product we want to find
     * @return              list of products with given name sorted by product price (cheapest first)
     */
    @Override
    public List<ProductDto> findProductsByName(String productName) {
       
        return productRepository.findByNameOrderByPriceAsc(productName)
        .stream()
        .map(ProductDto::of)
        .collect(Collectors.toList());
    }

    /**
     * Method returns all the products from the single store by given store id
     *
     * @param storeId       the store id to get all products
     * @return              list of product from the store with given id
     */
    @Override
    public List<ProductDto> findProductsByStoreId(Long storeId) {
      
        return productRepository.findByStoreId(storeId)
                              .stream()
                              .map(ProductDto::of)
                              .collect(Collectors.toList());
    }

  
}
