package com.ssafy.trip_coupon.domain.board.dto;


import com.ssafy.trip_coupon.domain.board.entity.Board;
import com.ssafy.trip_coupon.domain.user.entity.User;

public record BoardSaveRequestDTO(
        String title,
        String content
) {
    // DTO -> Entity
    public Board toEntity(User user) {
        return Board.builder()
                .user(user)
                .title(title)
                .content(content)
                .build();
    }
}
