package com.emlakjet.purchase.service;

import com.emlakjet.purchase.entity.Product;
import com.emlakjet.purchase.service.request.CreateProductServiceRequest;
import com.emlakjet.purchase.service.response.CreateProductServiceResponse;

import java.util.List;

public interface ProductService {
    CreateProductServiceResponse createProduct(CreateProductServiceRequest createProductServiceRequest);

    List<Product> getProduct();
}
