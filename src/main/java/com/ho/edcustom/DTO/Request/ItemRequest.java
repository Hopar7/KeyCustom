package com.ho.edcustom.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
    private String email;
    private String saveTime;
    private String bareboneColor;
    private String keyboardType;
    private String keycapColor;
    private String design;
    private String switchColor;  //스위치
}
