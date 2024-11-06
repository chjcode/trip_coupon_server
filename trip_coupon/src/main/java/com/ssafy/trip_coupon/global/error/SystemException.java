package com.ssafy.trip_coupon.global.error;

import com.ssafy.trip_coupon.global.error.code.ErrorCodeModel;
import lombok.Getter;

@Getter
public class SystemException extends RuntimeException {
    private final ErrorCodeModel errorCode;

    public SystemException(ErrorCodeModel errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }

    public SystemException(ErrorCodeModel errorCode, Throwable cause) {
        super(errorCode.getErrorMessage(), cause);
        this.errorCode = errorCode;
    }
}
