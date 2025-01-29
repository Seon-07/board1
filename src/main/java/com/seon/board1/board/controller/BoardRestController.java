package com.seon.board1.board.controller;

import com.seon.board1.board.dto.BoardReqDTO;
import com.seon.board1.board.dto.BoardResDTO;
import com.seon.board1.board.dto.UpdateBoardReqDTO;
import com.seon.board1.board.service.BoardService;
import com.seon.board1.common.response.ContentResult;
import com.seon.board1.common.response.OperationResponse;
import com.seon.board1.common.response.OperationResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/board")
public class BoardRestController {

    private final BoardService boardService;
    public BoardRestController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public ResponseEntity<ContentResult<List<BoardResDTO>>> getBoardList() {
        ContentResult<List<BoardResDTO>> response = OperationResponse.contentResult(boardService.getBoardList());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<ContentResult<BoardResDTO>> getBoard(@RequestParam String id) {
        ContentResult<BoardResDTO> response = OperationResponse.contentResult(boardService.getBoard(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<OperationResult> insertBoard(@RequestBody BoardReqDTO board) {
        OperationResult response = OperationResponse.operationResult(boardService.insertBoard(board));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<OperationResult> updateBoard(@RequestBody UpdateBoardReqDTO updateboard) {
        OperationResult response = OperationResponse.operationResult(boardService.updateBoard(updateboard));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
