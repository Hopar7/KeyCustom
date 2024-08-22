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

    public void saveItem(String email,String savetime,String barebonecolor,String barebonesize,String keycaps,String design,String keyswitch){
        itemRepository.save(Item.builder()
                .email(email)
                .savetime(savetime)
                .barebonecolor(barebonecolor)
                .barebonesize(barebonesize)
                .keycaps(keycaps)
                .design(design)
                .keyswitch(keyswitch)
                .build());
    }

    public List<Item> findcustomitem(String email)
    {
        return itemRepository.findItemByEmail(email);
    }

    


}
