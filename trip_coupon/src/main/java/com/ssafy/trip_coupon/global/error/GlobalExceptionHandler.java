package com.ssafy.trip_coupon.global.error;

import com.ssafy.trip_coupon.global.error.code.ErrorCodeModel;
import com.ssafy.trip_coupon.global.error.response.CustomResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SystemException.class)
    public ResponseEntity<CustomResponse> handleCustomException(SystemException exception, WebRequest request) {
        ErrorCodeModel errorCode = exception.getErrorCode();
        CustomResponse response = CustomResponse.error(errorCode);
        return new ResponseEntity<>(response, HttpStatus.valueOf(errorCode.getStatusCode()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomResponse> handleGlobalException(Exception exception, WebRequest request) {
        // 추후 UnExpectedErrorCode로 리팩토링 예정
        CustomResponse response = new CustomResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(), // status: 500
                "INTERNAL_SERVER_ERROR",
                "예기치 못한 오류가 발생했습니다."
        );
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
