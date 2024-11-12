package com.ssafy.trip_coupon.global.auth.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final RedisTemplate<String, String> redisTemplate;

    // 리프레시 토큰 저장
    public void saveRefreshToken(String userId, String refreshToken) {
        redisTemplate.opsForValue().set(userId, refreshToken, 30, TimeUnit.DAYS); // 30일 동안 저장
    }

    // 리프레시 토큰 조회
    public String getRefreshToken(String userId) {
        return redisTemplate.opsForValue().get(userId);
    }

    // 리프레시 토큰 삭제
    public void deleteRefreshToken(String userId) {
        redisTemplate.delete(userId);
    }
}

