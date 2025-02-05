package com.seon.board1.board.service;

import com.seon.board1.board.domain.Board;
import com.seon.board1.board.dto.BoardReqDTO;
import com.seon.board1.board.dto.BoardResDTO;
import com.seon.board1.board.dto.UpdateBoardReqDTO;
import com.seon.board1.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 게시글 서비스 클래스
 * @author SEON
 * @version 1.0
 * @Class BoardService
 * @since 25. 2. 5.
 */
@Service
public class BoardService {

    /**
     * 레포지토리 주입
     */
    private final BoardRepository boardRepository;
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    /**
     * 게시글 등록 서비스
     * @param boardReqDTO 등록할 게시글 객체
     * @return boolean
     * @author SEON
     * @since 25. 2. 5.
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean insertBoard(BoardReqDTO boardReqDTO) {
        Board board = new Board();
        board.setTitle(boardReqDTO.getTitle());
        board.setContent(boardReqDTO.getContent());
        board.setAuthor(boardReqDTO.getAuthor());
        boardRepository.save(board);
        return true;
    }

    /**
     * 게시글 수정 서비스
     * @param boardReqDTO 수정할 게시글 객체
     * @return boolean
     * @author SEON
     * @since 25. 2. 5.
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateBoard(UpdateBoardReqDTO boardReqDTO) {
        Board board = new Board();
        board.setId(boardReqDTO.getId());
        board.setTitle(boardReqDTO.getTitle());
        board.setContent(boardReqDTO.getContent());
        board.setAuthor(boardReqDTO.getAuthor());
        boardRepository.save(board);
        return true;
    }

    /**
     * 게시글 조회 서비스
     * @param id 조회할 게시글 기본키
     * @return BoardResDTO
     * @author SEON
     * @since 25. 2. 5.
     */
    public BoardResDTO getBoard(String id){
        Board board = boardRepository.findById(id).orElseThrow(() -> new RuntimeException("Board not found"));
        BoardResDTO boardResDTO = new BoardResDTO();
        boardResDTO.setId(board.getId());
        boardResDTO.setTitle(board.getTitle());
        boardResDTO.setContent(board.getContent());
        boardResDTO.setAuthor(board.getAuthor());
        return boardResDTO;
    }

    /**
     * 게시글 리스트 조회 서비스
     * @return List<BoardResDTO>
     * @author SEON
     * @since 25. 2. 5.
     */
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
