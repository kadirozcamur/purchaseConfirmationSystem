package com.emlakjet.purchase.api.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * The type Check invoice request.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@NotNull
public class CheckInvoiceRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String lastName;
    @NotBlank
    private String mail;
    private double amount;
    @NotBlank
    private String productName;
    @NotBlank
    private String billNo;
}
