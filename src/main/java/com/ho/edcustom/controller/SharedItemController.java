package com.ho.edcustom.controller;

import com.ho.edcustom.DTO.Request.ItemRequest;
import com.ho.edcustom.DTO.Response.HttpResponse;
import com.ho.edcustom.service.SharedItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SharedItemController {
    private final SharedItemService sharedItemService;
    @PostMapping("/shareditems/save")
    public ResponseEntity<HttpResponse> itemSave(@RequestBody ItemRequest DTO)
    {
        HttpResponse Response =sharedItemService.saveItem
                (DTO.getEmail(),
                        DTO.getBarebonecolor(),
                        DTO.getKeyboardtype(),
                        DTO.getKeycapcolor(),
                        DTO.getDesign(),
                        DTO.getSwitchcolor());
        return new ResponseEntity<>(Response,Response.getStatus());
    }
    @GetMapping("/shareditems/find")
    public ResponseEntity<HttpResponse> itemFind()
    {
        HttpResponse Response =sharedItemService.findItem();
        return new ResponseEntity<>(Response,Response.getStatus());
    }

}
