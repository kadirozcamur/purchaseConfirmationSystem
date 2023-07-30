package com.emlakjet.purchase.service.impl;

import com.emlakjet.purchase.entity.Expert;
import com.emlakjet.purchase.entity.Invoice;
import com.emlakjet.purchase.entity.Product;
import com.emlakjet.purchase.service.ExpertService;
import com.emlakjet.purchase.service.InvoiceService;
import com.emlakjet.purchase.service.ProductService;
import com.emlakjet.purchase.service.PurchaseService;
import com.emlakjet.purchase.service.request.CheckInvoiceServiceRequest;
import com.emlakjet.purchase.service.request.CreateProductServiceRequest;
import com.emlakjet.purchase.service.request.ExpertServiceRequest;
import com.emlakjet.purchase.service.response.CheckInvoiceServiceResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

/**
 * The type Purchase service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PurchaseServiceImpl implements PurchaseService {
    @Value("${emlakjet.invoice.limitation}")
    private double limit;

    private final ExpertService expertService;

    private final InvoiceService invoiceService;

    private final ProductService productService;

    @Override
    public CheckInvoiceServiceResponse check(CheckInvoiceServiceRequest purchaseCheckInvoiceServiceRequest) {

        Expert expert = this.expertService.inquireExpert(ExpertServiceRequest.builder().name(purchaseCheckInvoiceServiceRequest.getName()).lastName(purchaseCheckInvoiceServiceRequest.getLastName()).mail(purchaseCheckInvoiceServiceRequest.getMail()).build());

        List<Invoice> invoiceList = this.invoiceService.getAllInvoiceByExpert(expert.getId());

        Double totalAmount = invoiceList.stream().map(invoice -> invoice.getAmount()).reduce(0.0, Double::sum);

        Product product = productService.createProduct(CreateProductServiceRequest.builder().productName(purchaseCheckInvoiceServiceRequest.getProductName()).build()).getProduct();

        Invoice invoice = createInvoice(purchaseCheckInvoiceServiceRequest, expert, product);

        if (limit < purchaseCheckInvoiceServiceRequest.getAmount() + totalAmount) {
            invoice.setApproved(false);
            invoiceService.save(invoice);
            return CheckInvoiceServiceResponse.builder().status(HttpStatus.BAD_REQUEST).message("Invoice denied.").success(false).build();
        }
        invoice.setApproved(true);
        invoiceService.save(invoice);
        return CheckInvoiceServiceResponse.builder().status(HttpStatus.OK).message("Invoice approved.").success(true).build();
    }

    private Invoice createInvoice(CheckInvoiceServiceRequest purchaseCheckInvoiceServiceRequest, Expert expert, Product product) {
        return Invoice.builder().expertId(expert.getId()).createDate(ZonedDateTime.now()).updateDate(ZonedDateTime.now()).amount(purchaseCheckInvoiceServiceRequest.getAmount()).expert(expert).billNo(purchaseCheckInvoiceServiceRequest.getBillNo()).productName(purchaseCheckInvoiceServiceRequest.getProductName()).uuid(UUID.randomUUID()).product(product).build();
    }

}
