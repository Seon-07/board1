package com.seon.board1.board.domain;

import com.seon.board1.common.util.Base64Util;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    private String id;

    /** 게시글 제목 */
    private String title;

    /** 게시글 내용 */
    private String content;

    /** 게시글 작성자 */
    private String author;

    /**
     * 게시글 생성자
     * 객체 생성 시 id
     */
    public Board(){
        this.id = Base64Util.encodeBase64(UUID.randomUUID().toString());
    }
}
