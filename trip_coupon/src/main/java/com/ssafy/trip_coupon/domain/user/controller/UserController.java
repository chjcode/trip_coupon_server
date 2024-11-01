package com.ssafy.trip_coupon.domain.user.controller;

import com.ssafy.trip_coupon.domain.user.entity.User;
import com.ssafy.trip_coupon.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("")

    public ResponseEntity<?> createMemberIfNotExist(@RequestBody User user) {
        userService.createMemberIfNotExist(user);

        return new ResponseEntity<>("회원가입 성공", HttpStatus.CREATED);
    }

}
