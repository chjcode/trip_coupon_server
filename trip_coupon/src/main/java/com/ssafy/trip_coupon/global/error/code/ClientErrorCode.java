package com.ssafy.trip_coupon.global.error.code;

public enum ClientErrorCode implements ErrorCodeModel{
    UNAUTHORIZED(401, "UNAUTHORIZED", "인증이 필요합니다."),
    AUTHENTICATION_FAILED(401, "AUTHENTICATION_FAILED", "인증을 실패했습니다."),
    USER_NOT_FOUND_ERR(404, "USER_NOT_FOUND_ERR", "요청하신 사용자를 찾을 수 없습니다."),
    BOARD_SAVE_FAILED_ERR(500, "BOARD_SAVE_FAILED_ERR", "게시글 저장에 실패했습니다.");

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
        return this.statusCode;
    }

    @Override
    public String getSystemErrorCode() {
        return this.code;
    }

    @Override
    public String getErrorMessage() {
        return this.message;
    }
}
