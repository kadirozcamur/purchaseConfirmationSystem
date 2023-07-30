package com.emlakjet.purchase.service.impl;

import com.emlakjet.purchase.entity.Product;
import com.emlakjet.purchase.entity.SimpleProduct;
import com.emlakjet.purchase.repository.ProductRepository;
import com.emlakjet.purchase.repository.redis.ProductCacheRepository;
import com.emlakjet.purchase.service.ProductService;
import com.emlakjet.purchase.service.request.CreateProductServiceRequest;
import com.emlakjet.purchase.service.response.CreateProductServiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductCacheRepository productCacheRepository;

    @Override
    public CreateProductServiceResponse createProduct(CreateProductServiceRequest createProductServiceRequest) {
        Product product = productRepository.save(Product.builder().productName(createProductServiceRequest.getProductName()).createDate(ZonedDateTime.now()).updateDate(ZonedDateTime.now()).uuid(UUID.randomUUID()).build());
        productCacheRepository.save(SimpleProduct.builder().uuid(UUID.randomUUID()).productName(product.getProductName()).build());
        return CreateProductServiceResponse.builder().product(product).build();
    }

    @Override
    public List<SimpleProduct> getProduct() {
        List<SimpleProduct> simpleProducts = new ArrayList<>();
        for (SimpleProduct simpleProduct : productCacheRepository.findAll()) {
            simpleProducts.add(simpleProduct);
        }
        return simpleProducts;
    }
}
