package com.emlakjet.purchase.api.response;

import lombok.Builder;
import lombok.Data;

/**
 * The type Create expert response.
 */
@Data
@Builder
public class CreateExpertResponse {
    private boolean success;
    private String message;
}
