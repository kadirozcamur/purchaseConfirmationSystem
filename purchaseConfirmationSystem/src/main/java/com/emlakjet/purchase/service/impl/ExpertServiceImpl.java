package com.emlakjet.purchase.service.impl;

import com.emlakjet.purchase.service.request.ExpertServiceRequest;
import com.emlakjet.purchase.entity.Expert;
import com.emlakjet.purchase.repository.ExpertRepository;
import com.emlakjet.purchase.service.ExpertService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * The type Expert service.
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ExpertServiceImpl implements ExpertService {

    private final ExpertRepository expertRepository;

    @Override
    public Expert inquireExpert(ExpertServiceRequest expertRequest) {
        return expertRepository.findByNameAndLastNameAndMail(expertRequest.getName(), expertRequest.getLastName(), expertRequest.getMail()).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Expert createExpert(ExpertServiceRequest expertRequest) {
        return expertRepository.save(Expert.builder().createDate(ZonedDateTime.now()).updateDate(ZonedDateTime.now()).name(expertRequest.getName()).lastName(expertRequest.getLastName()).mail(expertRequest.getMail()).uuid(UUID.randomUUID()).build());
    }
}
