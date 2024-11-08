package com.ssafy.trip_coupon.domain.board.service;

import com.ssafy.trip_coupon.domain.board.dto.BoardSaveRequestDTO;
import com.ssafy.trip_coupon.domain.board.dto.BoardSaveResponseDTO;
import com.ssafy.trip_coupon.domain.board.entity.Board;
import com.ssafy.trip_coupon.domain.board.entity.BoardDAO;
import com.ssafy.trip_coupon.domain.user.entity.User;
import com.ssafy.trip_coupon.domain.user.entity.UserDAO;
import com.ssafy.trip_coupon.global.error.SystemException;
import com.ssafy.trip_coupon.global.error.code.ClientErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Transactional
@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardDAO boardDAO;
    private final UserDAO userDAO;

    public void save(Long loginUserId, BoardSaveRequestDTO requestDTO) {
        log.info("Saving board for user with ID: {}", loginUserId);
        User user = getUserById(loginUserId);
        Board board =  saveBoard(requestDTO, user);
        log.info("Board saved successfully with ID: {}", board.getId());
    }

    private User getUserById(Long id) {
        log.info("Fetching user with ID: {}", id);
        User user =  userDAO.findUserById(id);
        if (user == null) {
            log.error("User not found with ID: {}", id);
            throw new SystemException(ClientErrorCode.USER_NOT_FOUND_ERR);
        }
        log.info("User found with ID: {}", user.getId());
        return user;
    }

    private Board saveBoard(BoardSaveRequestDTO requestDTO, User user) {
        log.info("Saving board with title: {} for user with ID: {}", requestDTO.title(), user.getId());
        Board board = requestDTO.toEntity(user);
        int result = boardDAO.saveBoard(board);

        if (result != 1) {
            throw new SystemException(ClientErrorCode.BOARD_SAVE_FAILED_ERR);
        }

        return board;
    }
}
