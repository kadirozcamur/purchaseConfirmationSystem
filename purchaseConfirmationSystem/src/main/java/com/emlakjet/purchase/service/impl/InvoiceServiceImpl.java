package com.emlakjet.purchase.service.impl;

import com.emlakjet.purchase.entity.Invoice;
import com.emlakjet.purchase.repository.InvoiceRepository;
import com.emlakjet.purchase.service.InvoiceService;
import com.emlakjet.purchase.service.request.GetInvoiceListServiceRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Invoice service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public List<Invoice> getAllInvoiceByExpert(Long expertId) {
        return invoiceRepository.findByExpert_Id(expertId);
    }

    @Override
    public void save(Invoice invoice) {
        invoiceRepository.save(invoice);
    }

    @Override
    public List<Invoice> getInvoices(GetInvoiceListServiceRequest getInvoiceListServiceRequest) {
        return invoiceRepository.findAllByApproved(getInvoiceListServiceRequest.isApproved());
    }
}
