package com.emlakjet.purchase.service.request;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * The type Create product service request.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NotNull
@Builder
public class CreateProductServiceRequest {
    private String productName;
}
