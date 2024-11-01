package com.ssafy.trip_coupon.domain.attraction.entity;

import com.ssafy.trip_coupon.domain.contentType.entity.ContentType;
import com.ssafy.trip_coupon.domain.gugun.entity.Gugun;
import com.ssafy.trip_coupon.domain.sido.entity.Sido;
import com.ssafy.trip_coupon.domain.user.enums.Role;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Attraction {

    private Long id;
    private String title;
    private ContentType contentType;
    private Sido sido;
    private Gugun gugun;
    private String firstImageUrl;
    private String secondImageUrl;
    private Integer mapLevel;
    private BigDecimal latitude;    // 위도
    private BigDecimal longitude;   // 경도
    private String tel;
    private String firstAddress;
    private String secondAddress;
    private String homepage;
    private String overview;    //상세 설명
    private LocalDateTime createdAt;

    @Builder
    public Attraction(Long id, String title, ContentType contentType, Sido sido, Gugun gugun, String firstImageUrl,
                      String secondImageUrl, Integer mapLevel, BigDecimal latitude, BigDecimal longitude, String tel,
                      String firstAddress, String secondAddress, String homepage, String overview,
                      LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.contentType = contentType;
        this.sido = sido;
        this.gugun = gugun;
        this.firstImageUrl = firstImageUrl;
        this.secondImageUrl = secondImageUrl;
        this.mapLevel = mapLevel;
        this.latitude = latitude;
        this.longitude = longitude;
        this.tel = tel;
        this.firstAddress = firstAddress;
        this.secondAddress = secondAddress;
        this.homepage = homepage;
        this.overview = overview;
        this.createdAt = createdAt;
    }
}
