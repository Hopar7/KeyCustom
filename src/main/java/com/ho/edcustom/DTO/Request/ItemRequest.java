package com.ho.edcustom.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
    private String email;
    private String savetime;
    private String barebone;
    private String keycaps;
    private String design;//디자인
    private String keyswitch;  //스위치
}
