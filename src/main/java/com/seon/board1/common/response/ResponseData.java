package com.seon.board1.common.response;


public class ResponseData<T> {
    private T data;

    ResponseData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
