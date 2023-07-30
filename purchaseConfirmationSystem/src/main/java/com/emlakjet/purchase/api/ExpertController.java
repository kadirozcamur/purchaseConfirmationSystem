package com.emlakjet.purchase.api;

import com.emlakjet.purchase.api.mapper.ExpertMapper;
import com.emlakjet.purchase.api.request.ExpertRequest;
import com.emlakjet.purchase.api.response.CreateExpertResponse;
import com.emlakjet.purchase.common.response.BaseResponse;
import com.emlakjet.purchase.service.ExpertService;
import com.emlakjet.purchase.service.request.ExpertServiceRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * The type Expert controller.
 */
@RestController
@RequestMapping("/expert")
@RequiredArgsConstructor
public class ExpertController {

    private final ExpertService expertService;

    private final ExpertMapper expertMapper;

    /**
     * Create expert response entity.
     *
     * @param expertRequest the expert request
     * @return the response entity
     */
    @PostMapping("/createExpert")
    public ResponseEntity<BaseResponse<CreateExpertResponse>> createExpert(@Valid @RequestBody ExpertRequest expertRequest) {
        expertService.createExpert(ExpertServiceRequest.builder().name(expertRequest.getName()).lastName(expertRequest.getLastName()).mail(expertRequest.getMail()).build());
        return new ResponseEntity<>(new BaseResponse<>(expertMapper.toCreateExpertResponse(true, "Success")), HttpStatus.OK);
    }
}
