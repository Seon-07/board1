package com.seon.board1.board.domain;

import com.seon.board1.common.util.Base64Util;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * 게시글 엔티티
 * @author SEON
 * @version 1.0
 * @Class Board
 * @since 25. 2. 5.
 */
@Entity
@Getter
@Setter
public class Board {

    /** 게시글 기본키 */
    @Id
    private String id = UUID.randomUUID().toString();

    /** 게시글 제목 */
    @Column(nullable = false, length = 200)
    private String title;

    /** 게시글 내용 */
    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    /** 게시글 작성자 */
    @Column(nullable = false, length = 20)
    private String author;

    /** 게시글 사용여부 */
    @Column(nullable = false, length = 1)
    private String useYn = "Y";
}
