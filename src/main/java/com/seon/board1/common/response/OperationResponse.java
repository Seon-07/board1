package com.seon.board1.common.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class OperationResponse {

    private String message;
    private HttpStatus status;
    private ResponseData<?> data ;

    private OperationResponse(ResponseData<?> data, HttpStatus status, String message) {
        this.data = data;
        this.status = status;
        this.message = message;
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
