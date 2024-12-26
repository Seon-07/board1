package com.seon.board1.board.controller;

import com.seon.board1.board.dto.BoardReqDTO;
import com.seon.board1.board.service.BoardService;
import com.seon.board1.common.response.OperationResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/board")
public class BoardRestController {

    private final BoardService boardService;
    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public ResponseEntity<OperationResponse> getBoardService(@RequestParam String id) {
        OperationResponse response = OperationResponse.operationResponse(boardService.getBoard(id));
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PostMapping
    public ResponseEntity<OperationResponse> insertBoard(@RequestBody BoardReqDTO board) {
        OperationResponse response = OperationResponse.operationResponse(boardService.insertBoard(board));
        return new ResponseEntity<>(response, response.getStatus());
    }
}
