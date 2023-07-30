package com.emlakjet.purchase.common.response;

import lombok.*;

/**
 * The type Base response.
 *
 * @param <T> the type parameter
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse<T> {

    private T data;
    private boolean success = true;
    /**
     * The constant SUCCESS_RESPONSE.
     */
    public static final BaseResponse<Object> SUCCESS_RESPONSE = BaseResponse.builder().success(true).build();

    /**
     * Instantiates a new Base response.
     *
     * @param data the data
     */
    public BaseResponse(T data) {
        this.data = data;
    }
}
