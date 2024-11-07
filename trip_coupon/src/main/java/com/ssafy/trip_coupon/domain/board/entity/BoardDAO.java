package com.ssafy.trip_coupon.domain.board.entity;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardDAO {
    int saveBoard(Board board);
    int updateBoard(Board board);
    int deleteBoard(Long id);
    Board selectBoard(Long id);


}
