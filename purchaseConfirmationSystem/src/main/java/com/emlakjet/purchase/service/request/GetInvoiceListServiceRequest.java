package com.emlakjet.purchase.service.request;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * The type Get invoice list service request.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NotNull
@Builder
public class GetInvoiceListServiceRequest {
    private boolean approved;
}
