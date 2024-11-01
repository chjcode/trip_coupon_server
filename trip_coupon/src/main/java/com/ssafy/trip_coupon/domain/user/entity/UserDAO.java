package com.ssafy.trip_coupon.domain.user.entity;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {
    public void createUser(User user);
}
