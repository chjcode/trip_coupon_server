package com.ssafy.trip_coupon.domain.user.service;

import com.ssafy.trip_coupon.domain.user.entity.User;
import com.ssafy.trip_coupon.domain.user.entity.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDAO userDAO;

    public void createMemberIfNotExist(User user) {
        userDAO.createUser(user);
    }
}
