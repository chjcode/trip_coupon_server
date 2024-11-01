package com.ssafy.trip_coupon.global.util;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;

import com.ssafy.trip_coupon.global.auth.service.TokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;



@Component
public class JwtUtil {

    @Value("${jwt.salt}")
    private String SALT;
    private SecretKey secretKey;
    @Value("${jwt.access-expire-time}")
    private long ACCESS_EXPIRE_TIME;
    @Value("${jwt.refresh-expire-time}")
    private long REFRESH_EXPIRE_TIME;

    private TokenService tokenService;


    public JwtUtil(TokenService tokenService) {
        super();
        this.tokenService = tokenService;
    }

    @PostConstruct
    private void init() {
        secretKey = Keys.hmacShaKeyFor(SALT.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * Token 생성 paylod : { "userId":userId }
     *
     * @param userId
     * @return
     */
    public String createAccessToken(String userId) {

        Date exp = new Date(System.currentTimeMillis() + ACCESS_EXPIRE_TIME); // 1시간
        return Jwts.builder().header().add("type", "JWT").and().claim("userId", userId).expiration(exp)
                .signWith(secretKey).compact();
    }

    public String createRefreshToken(String userId) {
        Date exp = new Date(System.currentTimeMillis() + REFRESH_EXPIRE_TIME); // 만료 시간 설정

        String refreshToken = Jwts.builder().header().add("type", "JWT").and().claim("userId", userId).expiration(exp)
                .signWith(secretKey)
                .compact();

        tokenService.saveRefreshToken(userId, refreshToken);

        return refreshToken;
    }

    /**
     * Token 유효성 check
     *
     * @param token : request.getHeader("access-token")
     * @return
     */
    public Jws<Claims> validate(String token) {
        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token);
    }

    public String extractUserId(String token) {
        return validate(token).getBody().get("userId", String.class);
    }
}

