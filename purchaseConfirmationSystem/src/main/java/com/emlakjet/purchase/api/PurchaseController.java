package com.emlakjet.purchase.api;

import com.emlakjet.purchase.api.mapper.PurchaseMapper;
import com.emlakjet.purchase.api.request.CheckInvoiceRequest;
import com.emlakjet.purchase.api.response.CheckInvoiceResponse;
import com.emlakjet.purchase.common.response.BaseResponse;
import com.emlakjet.purchase.service.PurchaseService;
import com.emlakjet.purchase.service.response.CheckInvoiceServiceResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * The type Purchase controller.
 */
@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {
    private final PurchaseService purchaseService;

    private final PurchaseMapper purchaseMapper;

    /**
     * Check invoice response entity.
     *
     * @param checkInvoiceRequest the check invoice request
     * @return the response entity
     */
    @PostMapping("/checkInvoice")
    public ResponseEntity<BaseResponse<CheckInvoiceResponse>> checkInvoice(@Valid @RequestBody CheckInvoiceRequest checkInvoiceRequest) {
        CheckInvoiceServiceResponse checkInvoiceServiceResponse = this.purchaseService.check(this.purchaseMapper.toPurchaseCheckInvoiceServiceRequest(checkInvoiceRequest));
        return new ResponseEntity<>(new BaseResponse<>(purchaseMapper.toCheckInvoiceResponse(checkInvoiceServiceResponse.getMessage(), checkInvoiceServiceResponse.isSuccess())), checkInvoiceServiceResponse.getStatus());
    }
}
