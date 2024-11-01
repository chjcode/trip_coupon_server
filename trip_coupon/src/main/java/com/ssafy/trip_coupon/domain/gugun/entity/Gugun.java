package com.ssafy.trip_coupon.domain.gugun.entity;

import com.ssafy.trip_coupon.domain.attraction.entity.Attraction;
import com.ssafy.trip_coupon.domain.sido.entity.Sido;
import com.ssafy.trip_coupon.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Gugun {

    private Long id;
    private Sido sido;
    private Integer gugunCode;
    private String gugunName;

    @Builder
    public Gugun(Long id, Sido sido, Integer gugunCode, String gugunName) {
        this.id = id;
        this.sido = sido;
        this.gugunCode = gugunCode;
        this.gugunName = gugunName;
    }
}
