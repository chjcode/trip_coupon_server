package com.ssafy.trip_coupon.global.auth.controller;

import com.ssafy.trip_coupon.global.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/token/refresh")
    public ResponseEntity<String> refreshAccessToken(@RequestBody String refreshToken) {
        String newAccessToken = authService.refreshAccessToken(refreshToken); // 새로운 액세스 토큰 요청
        return ResponseEntity.ok(newAccessToken); // 새로운 액세스 토큰 반환
    }
}
