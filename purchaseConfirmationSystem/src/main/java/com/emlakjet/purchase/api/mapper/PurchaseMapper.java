package com.emlakjet.purchase.api.mapper;

import com.emlakjet.purchase.api.request.CheckInvoiceRequest;
import com.emlakjet.purchase.api.response.CheckInvoiceResponse;
import com.emlakjet.purchase.service.request.CheckInvoiceServiceRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PurchaseMapper {
    CheckInvoiceServiceRequest toPurchaseCheckInvoiceServiceRequest(CheckInvoiceRequest checkInvoiceRequest);

    CheckInvoiceResponse toCheckInvoiceResponse(String message, boolean success);
}
