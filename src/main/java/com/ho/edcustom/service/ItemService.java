package com.ho.edcustom.service;

import com.ho.edcustom.DTO.Response.HttpResponse;
import com.ho.edcustom.entity.Item;
import com.ho.edcustom.enumSet.ErrorCode;
import com.ho.edcustom.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public HttpResponse saveItem(String email,String saveTime,String barebonecolor,String keyboardtype,String keycapcolor,String design,String switchcolor){

        if (Stream.of(email, saveTime, barebonecolor, keyboardtype, keycapcolor, design, switchcolor)
                .anyMatch(str -> str == null || str.isBlank())) {
            return new HttpResponse(HttpStatus.BAD_REQUEST, ErrorCode.ITEM_BAD_REQUEST,null);
        }


        itemRepository.save(Item.builder()
                .email(email)
                .savetime(saveTime)
                .barebonecolor(barebonecolor)
                .keyboardtype(keyboardtype)
                .keycapcolor(keycapcolor)
                .design(design)
                .switchcolor(switchcolor)
                .build());

        return new HttpResponse(HttpStatus.CREATED, ErrorCode.CREATED,null);
    }

//    public List<Item> findcustomitem(String email)
//    {
//        return itemRepository.findItemByEmail(email);
//
//
//    }


    public HttpResponse findcustomitem(String email)
    {
        if (itemRepository.findItemByEmail(email).isEmpty()) {
            return new HttpResponse(HttpStatus.NOT_FOUND,ErrorCode.NOT_FOUND,null);
            //현재 not found만 있는데 id가 틀릴경우도 제어해야함.
        }
        List<Item> list =itemRepository.findItemByEmail(email);
        return new HttpResponse(HttpStatus.OK,ErrorCode.SUCCESS,list);
    }

}
