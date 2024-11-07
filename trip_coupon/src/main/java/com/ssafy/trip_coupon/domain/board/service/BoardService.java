package com.ssafy.trip_coupon.domain.board.service;

import com.ssafy.trip_coupon.domain.board.dto.BoardSaveRequestDTO;
import com.ssafy.trip_coupon.domain.board.entity.Board;
import com.ssafy.trip_coupon.domain.board.entity.BoardDAO;
import com.ssafy.trip_coupon.domain.user.entity.User;
import com.ssafy.trip_coupon.domain.user.entity.UserDAO;
import com.ssafy.trip_coupon.global.error.SystemException;
import com.ssafy.trip_coupon.global.error.code.ClientErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardDAO boardDAO;
    private final UserDAO userDAO;

    public void save(Long loginUserId, BoardSaveRequestDTO requestDTO) {
        User user = getUserById(loginUserId);
        Board board =  saveBoard(requestDTO, user);


    }

    private User getUserById(Long id) {
        User user =  userDAO.findUserById(id);
        if (user == null) {
            throw new SystemException(ClientErrorCode.USER_NOT_FOUND_ERR);
        }

        return user;
    }

    private Board saveBoard(BoardSaveRequestDTO requestDTO, User user) {
        Board board = requestDTO.toEntity(user);
        int result = boardDAO.saveBoard(board);

        if (result != 1) {
            throw new SystemException(ClientErrorCode.BOARD_SAVE_FAILED_ERR);
        }

        return board;
    }
}
