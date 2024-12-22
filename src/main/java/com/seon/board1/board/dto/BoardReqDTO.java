package com.seon.board1.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BoardReqDTO {
    private String title;
    private String content;
    private String author;
}
