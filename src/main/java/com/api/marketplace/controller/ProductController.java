package com.api.marketplace.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.marketplace.controller.exception.ResourceNotFoundException;
import com.api.marketplace.dto.ProductDto;
import com.api.marketplace.service.ProductService;


@RestController
@RequestMapping("/")
public class ProductController {

   private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping(value = "product/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDto getProduct(@PathVariable Long id) {
        return productService.getProduct(id)
                           .orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping(value = "store/{storeId}/product")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductDto>> getProductByStore(@PathVariable Long storeId){
       

        List<ProductDto> products = productService.findProductsByStoreId(storeId);
        return new ResponseEntity<>(products, !products.isEmpty()? HttpStatus.OK : HttpStatus.NOT_FOUND);
        
    }


    @PostMapping(value = "store/{storeId}/product")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto addProduct(@RequestBody ProductDto product, @PathVariable Long storeId){

            return productService.addProduct(product, storeId);
    }



    @GetMapping(value = "product/find/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Iterable<ProductDto>> getProductByName(@PathVariable String name){

        List<ProductDto> products = productService.findProductsByName(name);
        return new ResponseEntity<>(products, !products.isEmpty()? HttpStatus.OK : HttpStatus.NOT_FOUND);

    }






}
