package com.ssafy.trip_coupon.global.error.code;

public enum ClientErrorCode implements ErrorCodeModel{
    UNAUTHORIZED(401, "UNAUTHORIZED", "인증이 필요합니다."),
    AUTHENTICATION_FAILED(401, "AUTHENTICATION_FAILED", "인증을 실패했습니다.");

    private final int statusCode;
    private final String code;
    private final String message;

    ClientErrorCode(int statusCode, String code, String message) {
        this.statusCode = statusCode;
        this.code = code;
        this.message = message;
    }

    @Override
    public int getStatusCode() {
        return 0;
    }

    @Override
    public String getSystemErrorCode() {
        return "";
    }

    @Override
    public String getErrorMessage() {
        return "";
    }
}
