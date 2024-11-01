package com.ssafy.trip_coupon.domain.user.entity;

import com.ssafy.trip_coupon.domain.user.enums.Role;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class User {

    private Long id;
    private String nickname;
    private String email;
    private String password;
    private Role role;
    private LocalDateTime registeredAt;

    @Builder
    public User(Long id, String nickname, String email, String password, Role role, LocalDateTime registeredAt) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.registeredAt = registeredAt;
    }
}
