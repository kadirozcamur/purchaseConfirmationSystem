package com.emlakjet.purchase.service;

import com.emlakjet.purchase.entity.Invoice;
import com.emlakjet.purchase.service.request.GetInvoiceListServiceRequest;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getAllInvoiceByExpert(Long expertId);

    void save(Invoice invoice);

    List<Invoice> getInvoices(GetInvoiceListServiceRequest getInvoiceListServiceRequest);
}
