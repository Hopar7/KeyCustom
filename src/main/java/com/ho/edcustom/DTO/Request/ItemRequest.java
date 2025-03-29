package com.ho.edcustom.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
    private String email;
    private String barebonecolor;
    private String keyboardtype;
    private String keycapcolor;
    private String design;
    private String switchcolor;
}
