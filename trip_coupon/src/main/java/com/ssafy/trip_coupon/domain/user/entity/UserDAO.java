package com.ssafy.trip_coupon.domain.user.entity;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    void createUser(User user);
    User findUserByEmail(String email);
    User findUserById(Long id);
}
