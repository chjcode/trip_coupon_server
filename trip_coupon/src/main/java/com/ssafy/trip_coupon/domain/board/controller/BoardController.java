package com.ssafy.trip_coupon.domain.board.controller;


import com.ssafy.trip_coupon.domain.board.dto.BoardSaveRequestDTO;
import com.ssafy.trip_coupon.domain.board.dto.BoardSaveResponseDTO;
import com.ssafy.trip_coupon.domain.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/{userId}")
    private ResponseEntity<Void> save(
            @PathVariable(name = "userId") Long userId,
            @RequestBody BoardSaveRequestDTO requestDTO) {
        boardService.save(userId, requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
