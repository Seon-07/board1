package com.seon.board1.board.repository;

import com.seon.board1.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * 게시글 레포지토리
 * @author SEON
 * @version 1.0
 * @Class BoardRepository
 * @since 25. 2. 5.
 */
@Repository
public interface BoardRepository extends JpaRepository<Board, String> {

    /**
     * 게시글 소프트 삭제
     * @param id 게시글의 기본키
     * @return 성공했을떄 1, id가 없으면 0
     * @author SEON
     * @since 25. 2. 6.
     */
    @Modifying
    @Query("UPDATE Board b SET b.useYN = 'N' WHERE b.id = :id")
    int deleteBoardById(String id);
}
