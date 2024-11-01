package com.ssafy.trip_coupon.domain.sido.entity;

import com.ssafy.trip_coupon.domain.user.enums.Role;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class Sido {

    private Long id;
    private Integer sidoCode;
    private String sidoName;

    @Builder
    public Sido(Long id, Integer sidoCode, String sidoName) {
        this.id = id;
        this.sidoCode = sidoCode;
        this.sidoName = sidoName;
    }
}
