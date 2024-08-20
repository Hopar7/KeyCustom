package com.ho.edcustom.controller;

import com.ho.edcustom.DTO.Request.ItemRequest;
import com.ho.edcustom.service.ItemService;
import com.ho.edcustom.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @PostMapping("/items/save")
    public void itemsave(@RequestBody ItemRequest DTO)
    {
        itemService.saveItem(DTO.getEmail(),DTO.getSavetime(),DTO.getBarebone(),DTO.getKeycaps(),DTO.getDesign(),DTO.getKeyswitch());
    }

}
