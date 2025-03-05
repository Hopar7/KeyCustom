package com.ho.edcustom.enumSet;

import lombok.Getter;

@Getter
public enum HttpResponse {
    SUCCESS(200, "OK", "요청을 성공적으로 처리했습니다."),
    BAD_REQUEST(400, "BAD_REQUEST", "잘못된 요청입니다."),
    Unauthorized(401, "Unauthorized", "권한이 없습니다."),
    INTERNAL_ERROR(500, "INTERNAL_ERROR", "서버에 에러가 발생했습니다.");

    private final int statusCode;
    private final String statusMessage;
    private final String clientMessage;

    HttpResponse(int statusCode,String statusMessage,String clientMessage)
    {
        this.statusCode=statusCode;
        this.statusMessage=statusMessage;
        this.clientMessage=clientMessage;
    }

}
