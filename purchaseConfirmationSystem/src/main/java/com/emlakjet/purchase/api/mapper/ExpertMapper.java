package com.emlakjet.purchase.api.mapper;

import com.emlakjet.purchase.api.response.CreateExpertResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExpertMapper {
    CreateExpertResponse toCreateExpertResponse(Boolean success
            , String message);
}
