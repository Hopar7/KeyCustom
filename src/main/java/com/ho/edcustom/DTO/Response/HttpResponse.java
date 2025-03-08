package com.ho.edcustom.DTO.Response;

import com.ho.edcustom.enumSet.ErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class HttpResponse {

    private final HttpStatus status;
    private final int code;
    private final String message;
    private final String token;

    public HttpResponse(HttpStatus status,ErrorCode code,String token){
        this.status=status;
        this.code=code.getCode();
        this.message=code.getMessage();
        this.token=token;

    }


}
