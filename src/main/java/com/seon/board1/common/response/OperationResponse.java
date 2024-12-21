package com.seon.board1.common.response;

import org.springframework.http.HttpStatus;

public class OperationResponse {

    private String message;
    private HttpStatus status;
    private ResponseData<?> data ;

    private OperationResponse(ResponseData<?> data, HttpStatus status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public ResponseData<?> getData() {
        return data;
    }

    public static <T> OperationResponse operationResponse(T data){
        return new OperationResponse(new ResponseData<>(data), HttpStatus.OK, "SUCCESS");
    }

    public static <T> OperationResponse operationResponse(T data, HttpStatus status, String message){
        return new OperationResponse(new ResponseData<>(data), status, message);
    }
}
