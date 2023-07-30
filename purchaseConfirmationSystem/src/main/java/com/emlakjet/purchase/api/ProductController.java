package com.emlakjet.purchase.api;

import com.emlakjet.purchase.entity.SimpleProduct;
import com.emlakjet.purchase.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(name = "/product-list")
    public List<SimpleProduct> getProduct() {
        return productService.getProduct();
    }
}
