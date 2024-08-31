package com.ho.edcustom.controller;

import com.ho.edcustom.DTO.Request.EmailRequest;
import com.ho.edcustom.DTO.Request.ItemRequest;
import com.ho.edcustom.entity.Item;
import com.ho.edcustom.service.ItemService;
import com.ho.edcustom.service.KakaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @PostMapping("/items/save")
    public void itemSave(@RequestBody ItemRequest DTO)
    {
        itemService.saveItem(DTO.getEmail(),DTO.getSavetime(),DTO.getBarebonecolor(),DTO.getKeyboardtype(),DTO.getKeyboardtype(),DTO.getDesign(),DTO.getSwitchcolor());
    }
    @PostMapping("/items/find")
    public ResponseEntity<List<Item>> itemFind(@RequestBody EmailRequest DTO)
    {
        List<Item> items = itemService.findcustomitem(DTO.getEmail());
        if (items.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(items);
    }

}
