package com.seon.board1.common.response;

import lombok.Getter;

@Getter
public class ResponseData<T> {
    private T data;

    ResponseData(T data) {
        this.data = data;
    }
}
