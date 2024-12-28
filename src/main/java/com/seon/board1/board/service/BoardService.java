package com.seon.board1.board.service;

import com.seon.board1.board.domain.Board;
import com.seon.board1.board.dto.BoardReqDTO;
import com.seon.board1.board.dto.BoardResDTO;
import com.seon.board1.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean insertBoard(BoardReqDTO boardReqDTO) {
        Board board = new Board();
        board.setTitle(boardReqDTO.getTitle());
        board.setContent(boardReqDTO.getContent());
        board.setAuthor(boardReqDTO.getAuthor());
        boardRepository.save(board);
        return true;
    }

    public BoardResDTO getBoard(String id){
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("Board not found"));
        BoardResDTO boardResDTO = new BoardResDTO();
        boardResDTO.setId(board.getId());
        boardResDTO.setTitle(board.getTitle());
        boardResDTO.setContent(board.getContent());
        boardResDTO.setAuthor(board.getAuthor());
        return boardResDTO;
    }

    public List<BoardResDTO> getBoardList(){
        List<Board> boardList = boardRepository.findAll();
        List<BoardResDTO> boardResDTOList = new ArrayList<>();
        for(Board board : boardList){
            BoardResDTO boardResDTO = new BoardResDTO();
            boardResDTO.setId(board.getId());
            boardResDTO.setTitle(board.getTitle());
            boardResDTO.setContent(board.getContent());
            boardResDTO.setAuthor(board.getAuthor());
            boardResDTOList.add(boardResDTO);
        }
        return boardResDTOList;
    }
}
