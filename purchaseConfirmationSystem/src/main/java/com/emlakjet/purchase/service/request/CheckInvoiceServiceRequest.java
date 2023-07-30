package com.emlakjet.purchase.service.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Check invoice service request.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CheckInvoiceServiceRequest {
    private String name;
    private String lastName;
    private String mail;
    private double amount;
    private String productName;
    private String billNo;
}
