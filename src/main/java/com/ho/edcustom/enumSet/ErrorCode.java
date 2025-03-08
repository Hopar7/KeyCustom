package com.ho.edcustom.enumSet;

import lombok.Getter;

@Getter
public enum ErrorCode {
    SUCCESS(200, "요청을 성공적으로 처리했습니다."),
    BAD_REQUEST(400, "잘못된 요청입니다."),
    UNAUTHORIZED(401, "권한이 없습니다."),
    INTERNAL_ERROR(500, "서버에 에러가 발생했습니다.");


    private final int code;
    private final String message;

    ErrorCode(int code,String message)
    {
        this.code=code;
        this.message=message;
    }

}
