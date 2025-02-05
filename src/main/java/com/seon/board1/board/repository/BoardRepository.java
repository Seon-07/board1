package com.seon.board1.board.repository;

import com.seon.board1.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 게시글 레포지토리
 * @author SEON
 * @version 1.0
 * @Class BoardRepository
 * @since 25. 2. 5.
 */
@Repository
public interface BoardRepository extends JpaRepository<Board, String> {
}
