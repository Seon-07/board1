package com.seon.board1.board.domain;

import com.seon.board1.common.util.Base64Util;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Board {

    @Id
    private String id;

    private String title;

    private String content;

    private String author;

    public Board(){
        this.id = Base64Util.encodeBase64(UUID.randomUUID().toString());
    }
}
