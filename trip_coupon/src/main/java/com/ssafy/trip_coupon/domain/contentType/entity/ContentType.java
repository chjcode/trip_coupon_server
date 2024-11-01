package com.ssafy.trip_coupon.domain.contentType.entity;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ContentType {

    private Long id;
    private String contentTypeName;

    @Builder

    public ContentType(Long id, String contentTypeName) {
        this.id = id;
        this.contentTypeName = contentTypeName;
    }
}
