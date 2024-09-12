package com.ecom.microservices.productService.service;

import com.ecom.microservices.productService.dto.ProductRequest;
import com.ecom.microservices.productService.dto.ProductResponse;
import com.ecom.microservices.productService.model.Product;
import com.ecom.microservices.productService.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();
        productRepository.save(product);
        log.info("product created successfully");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(),product.getPrice());
    }

    public List<ProductResponse> getAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(),product.getPrice()))
                .toList();
    }
}
