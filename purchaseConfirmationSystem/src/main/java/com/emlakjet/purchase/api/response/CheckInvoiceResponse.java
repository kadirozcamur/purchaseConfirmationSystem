package com.emlakjet.purchase.api.response;

import lombok.Builder;
import lombok.Data;

/**
 * The type Check invoice response.
 */
@Data
@Builder
public class CheckInvoiceResponse {
    private String message;
    private boolean success;
}
