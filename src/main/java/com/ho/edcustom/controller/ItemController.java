package com.ho.edcustom.controller;

import com.ho.edcustom.DTO.Request.EmailRequest;
import com.ho.edcustom.DTO.Request.ItemRequest;
import com.ho.edcustom.DTO.Response.HttpResponse;
import com.ho.edcustom.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @PostMapping("/items/save")
    public ResponseEntity<HttpResponse> itemSave(@RequestBody ItemRequest DTO)
    {
        HttpResponse Response =itemService.saveItem
                (DTO.getEmail(),
                 DTO.getBarebonecolor(),
                 DTO.getKeyboardtype(),
                 DTO.getKeycapcolor(),
                 DTO.getDesign(),
                 DTO.getSwitchcolor(),
                 DTO.getItemimage());
        return new ResponseEntity<>(Response,Response.getStatus());
    }
    @PostMapping("/items/find")
    public ResponseEntity<HttpResponse> itemFind(@RequestBody EmailRequest DTO)
    {
        HttpResponse Response =itemService.findcustomitem(DTO.getEmail());
        return new ResponseEntity<>(Response,Response.getStatus());
    }

}
