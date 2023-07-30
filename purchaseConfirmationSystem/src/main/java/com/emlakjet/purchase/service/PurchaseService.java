package com.emlakjet.purchase.service;

import com.emlakjet.purchase.service.request.CheckInvoiceServiceRequest;
import com.emlakjet.purchase.service.response.CheckInvoiceServiceResponse;

public interface PurchaseService {
    CheckInvoiceServiceResponse check(CheckInvoiceServiceRequest purchaseCheckInvoiceServiceRequest);
}
