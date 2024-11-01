package com.ssafy.trip_coupon.global.auth.service;

import com.ssafy.trip_coupon.global.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private TokenService tokenService; // Redis에 리프레시 토큰을 저장하는 서비스

    // 리프레시 토큰을 사용하여 새로운 액세스 토큰을 발급
    public String refreshAccessToken(String refreshToken) {
        String userId = jwtUtil.extractUserId(refreshToken); // 리프레시 토큰에서 userId 추출
        String storedToken = tokenService.getRefreshToken(userId); // Redis에서 저장된 리프레시 토큰 조회

        // 리프레시 토큰 검증
        if (storedToken != null && storedToken.equals(refreshToken)) {
            return jwtUtil.createAccessToken(userId); // 새로운 액세스 토큰 생성
        }
        throw new RuntimeException("Invalid refresh token"); // 유효하지 않은 경우 예외 처리
    }
}
