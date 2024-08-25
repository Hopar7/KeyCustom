package com.ho.edcustom.service;

import com.ho.edcustom.entity.Item;
import com.ho.edcustom.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void saveItem(String email,String saveTime,String bareboneColor,String keyboardType,String keycapColor,String design,String switchColor){
        itemRepository.save(Item.builder()
                .email(email)
                .savetime(saveTime)
                .barebonecolor(bareboneColor)
                .keyboardtype(keyboardType)
                .keycapcolor(keycapColor)
                .design(design)
                .switchcolor(switchColor)
                .build());
    }

    public List<Item> findcustomitem(String email)
    {
        return itemRepository.findItemByEmail(email);
    }

    


}
