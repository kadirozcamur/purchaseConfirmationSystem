package com.emlakjet.purchase.service.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * The type Check invoice service response.
 */
@Data
@Builder
public class CheckInvoiceServiceResponse {
    private HttpStatus status;
    private boolean success;
    private String message;
}
