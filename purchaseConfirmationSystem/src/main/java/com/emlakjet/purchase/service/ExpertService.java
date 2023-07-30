package com.emlakjet.purchase.service;

import com.emlakjet.purchase.service.request.ExpertServiceRequest;
import com.emlakjet.purchase.entity.Expert;

public interface ExpertService {

    Expert inquireExpert(ExpertServiceRequest inquireExpertRequest);

    Expert createExpert(ExpertServiceRequest expertRequest);
}
