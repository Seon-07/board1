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

    public static OperationResponse operationResponse(boolean success){
        HttpStatus status = success ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR;
        String message = success ? "SUCCESS" : "FAIL";
        return new OperationResponse(null, status, message);
    }
}
