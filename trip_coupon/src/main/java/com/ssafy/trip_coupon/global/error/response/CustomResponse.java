package com.ssafy.trip_coupon.global.error.response;

import com.ssafy.trip_coupon.global.error.code.ErrorCodeModel;

public record CustomResponse(
        int status,
        String code,
        String description
) {
    public static CustomResponse error(ErrorCodeModel errorCode) {
        return new CustomResponse(
                errorCode.getStatusCode(),
                errorCode.getSystemErrorCode(),
                errorCode.getErrorMessage()
        );
    }

    public static CustomResponse success(ErrorCodeModel successCode) {
        return new CustomResponse(
                successCode.getStatusCode(),
                successCode.getSystemErrorCode(),
                successCode.getErrorMessage()
        );
    }
}
