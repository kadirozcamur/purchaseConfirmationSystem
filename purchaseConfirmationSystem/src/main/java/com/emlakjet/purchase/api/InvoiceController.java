package com.emlakjet.purchase.api;

import com.emlakjet.purchase.entity.Invoice;
import com.emlakjet.purchase.service.InvoiceService;
import com.emlakjet.purchase.service.request.GetInvoiceListServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Invoice controller.
 */
@RestController
@RequestMapping("/invoice")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService invoiceService;

    /**
     * Gets invoices.
     *
     * @param approved the approved
     * @return the invoices
     */
    @GetMapping(name = "/invoice-list")
    public ResponseEntity<List<Invoice>> getInvoices(@RequestParam(defaultValue = "true") boolean approved) {
        return new ResponseEntity<>(invoiceService.getInvoices(GetInvoiceListServiceRequest.builder().approved(approved).build()), HttpStatus.OK);
    }
}
