package com.emlakjet.purchase.api;

import com.emlakjet.purchase.entity.Product;
import com.emlakjet.purchase.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The type Product controller.
 */
@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * Gets product.
     *
     * @return the product
     */
    @GetMapping(name = "/product-list")
    public List<Product> getProduct() {
        return productService.getProduct();
    }
}
