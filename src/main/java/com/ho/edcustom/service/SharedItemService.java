package com.ho.edcustom.service;


import com.ho.edcustom.DTO.Response.HttpResponse;
import com.ho.edcustom.entity.SharedItem;
import com.ho.edcustom.enumSet.ErrorCode;
import com.ho.edcustom.repository.SharedItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class SharedItemService {
    private final SharedItemRepository sharedItemRepository;

    public HttpResponse saveItem(String email, String barebonecolor, String keyboardtype, String keycapcolor, String design, String switchcolor,String imageurl){

        if (Stream.of(email, barebonecolor, keyboardtype, keycapcolor, design, switchcolor)
                .anyMatch(str -> str == null || str.isBlank())) {
            return new HttpResponse(HttpStatus.BAD_REQUEST, ErrorCode.ITEM_BAD_REQUEST,null);
        }


        sharedItemRepository.save(SharedItem.builder()
                .email(email)
                .barebonecolor(barebonecolor)
                .keyboardtype(keyboardtype)
                .keycapcolor(keycapcolor)
                .design(design)
                .switchcolor(switchcolor)
                .imageurl(imageurl)
                .createdAt(LocalDateTime.now())
                .lastModifiedAt(LocalDateTime.now())
                .sharedBy(email)
                .likes(0)
                .build());

        return new HttpResponse(HttpStatus.CREATED, ErrorCode.CREATED,null);
    }

    public HttpResponse findItem()
    {
        if (sharedItemRepository.findAll().isEmpty()) {
            return new HttpResponse(HttpStatus.NOT_FOUND,ErrorCode.CUSTOM_NOT_FOUND,null);
            //현재 not found만 있는데 id가 틀릴경우도 제어해야함.
        }
        List<SharedItem> list =sharedItemRepository.findAll();
        return new HttpResponse(HttpStatus.OK,ErrorCode.SUCCESS,list);
    }
}
