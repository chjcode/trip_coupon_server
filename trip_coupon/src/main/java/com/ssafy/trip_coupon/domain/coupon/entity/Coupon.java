package com.ssafy.trip_coupon.domain.coupon.entity;

import com.ssafy.trip_coupon.domain.attraction.entity.Attraction;
import com.ssafy.trip_coupon.domain.user.entity.User;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Coupon {

    private Long id;
    private Attraction attraction;
    private User user;
    private Integer publishedNumber;

    @Builder
    public Coupon(Long id, Attraction attraction, User user, Integer publishedNumber) {
        this.id = id;
        this.attraction = attraction;
        this.user = user;
        this.publishedNumber = publishedNumber;
    }
}
