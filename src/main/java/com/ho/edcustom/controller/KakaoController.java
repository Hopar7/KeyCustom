package com.ho.edcustom.controller;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.ho.edcustom.DTO.Request.KakaoLoginRequest;
import com.ho.edcustom.DTO.Response.LoginResponse;
import com.ho.edcustom.service.KakaoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class KakaoController {
    private final KakaoService kakaoService;

    @ResponseBody
    @PostMapping("/social/kakao/login")
    public LoginResponse kakaoLogin(@RequestBody KakaoLoginRequest DTO) throws JsonProcessingException {
        LoginResponse Response = new LoginResponse(kakaoService.kakaoLogin(DTO.getCode()));
        return Response;
    }
    
}

