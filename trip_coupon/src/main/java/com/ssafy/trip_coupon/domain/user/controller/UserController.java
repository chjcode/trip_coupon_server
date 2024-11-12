package com.ssafy.trip_coupon.domain.user.controller;

import com.ssafy.trip_coupon.domain.user.entity.User;
import com.ssafy.trip_coupon.domain.user.service.UserService;
import com.ssafy.trip_coupon.global.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    @PostMapping("/signup")
    public ResponseEntity<?> createMemberIfNotExist(@RequestBody User user) {
        userService.createMemberIfNotExist(user);

        return new ResponseEntity<>("회원가입 성공", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        System.out.println(user.getPassword());
        User loginUser = userService.login(email, password);
        System.out.println(loginUser.toString());

        if(loginUser != null) {
            log.info("AccessToken 생성 시작");
            String accessToken = jwtUtil.createAccessToken(email);
            log.info("AccessToken 생성 완료 : {}" , accessToken);
            log.info("RefreshToken 생성 시작");
            String refreshToken = jwtUtil.createRefreshToken(email);
            log.info("RefreshToken 생성 완료 : {}", refreshToken);
            return ResponseEntity.ok()
                    .header("Authorization", "Bearer " + accessToken)
                    .header("access-token", accessToken)
                    .header("Set-Cookie", "refreshToken=" + refreshToken + "; HttpOnly; Path=/; Max-Age=2592000") // 30일 쿠키 설정
                    .body("login success");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("login failed");
        }


    }

}
