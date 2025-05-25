package com.ho.edcustom.DTO.Request;

import com.fasterxml.jackson.databind.JsonNode;
import com.ho.edcustom.DTO.KeyCaps;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
    private String email;
    private String title;
    private String barebonecolor;
    private String keyboardtype;
    private Map<String, String> keycapcolor;
    private String switchcolor;
    //private String itemimage;
}
