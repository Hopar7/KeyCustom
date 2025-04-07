package com.ho.edcustom.service;

import com.ho.edcustom.DTO.Response.HttpResponse;
import com.ho.edcustom.entity.Item;
import com.ho.edcustom.enumSet.ErrorCode;
import com.ho.edcustom.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final FireBaseService fireBaseService;
    public HttpResponse saveItem(String email, String barebonecolor, String keyboardtype, String keycapcolor, String design, String switchcolor, MultipartFile multipartFile) throws IOException {

        if (Stream.of(email, barebonecolor, keyboardtype, keycapcolor, design, switchcolor)
                .anyMatch(str -> str == null || str.isBlank())) {
            return new HttpResponse(HttpStatus.BAD_REQUEST, ErrorCode.ITEM_BAD_REQUEST,null);
        }
        String imageUrl =fireBaseService.uploadItem(multipartFile);

        itemRepository.save(Item.builder()
                .email(email)
                .barebonecolor(barebonecolor)
                .keyboardtype(keyboardtype)
                .keycapcolor(keycapcolor)
                .design(design)
                .switchcolor(switchcolor)
                .imageUrl(imageUrl)
                .createdAt(LocalDateTime.now())
                .lastModifiedAt(LocalDateTime.now())
                .createdBy(email)
                .build());

        return new HttpResponse(HttpStatus.CREATED, ErrorCode.CREATED,null);
    }


    public HttpResponse findcustomitem(String email)
    {
        if (itemRepository.findItemByEmail(email).isEmpty()) {
            return new HttpResponse(HttpStatus.NOT_FOUND,ErrorCode.CUSTOM_NOT_FOUND,null);
            //현재 not found만 있는데 id가 틀릴경우도 제어해야함.
        }
        List<Item> list =itemRepository.findItemByEmail(email);
        return new HttpResponse(HttpStatus.OK,ErrorCode.SUCCESS,list);
    }

}
