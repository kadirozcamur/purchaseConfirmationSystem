package com.emlakjet.purchase.service.response;

import com.emlakjet.purchase.entity.Product;
import lombok.Builder;
import lombok.Data;

/**
 * The type Create product service response.
 */
@Data
@Builder
public class CreateProductServiceResponse {
    private Product product;
}
