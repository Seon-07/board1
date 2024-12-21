package com.seon.board1.board.controller;

import com.seon.board1.board.service.BoardService;
import com.seon.board1.common.response.OperationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/board")
public class BoardRestController {

    @Autowired
    private BoardService boardService;

    @GetMapping
    public ResponseEntity<OperationResponse> getBoardService() {
        OperationResponse response = OperationResponse.operationResponse(boardService.getBoard());

        return new ResponseEntity<>(response, response.getStatus());
    }

    @PostMapping
    public boolean insertBoard() {
        return boardService.insertBoard();
    }
}
