package com.ho.edcustom.service;

import com.ho.edcustom.entity.Item;
import com.ho.edcustom.entity.Member;
import com.ho.edcustom.repository.ItemRepository;
import com.ho.edcustom.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;

    public void saveItem(String email,String savetime,String barebone,String keycaps,String design,String keyswitch){
        itemRepository.save(Item.builder()
                .email(email)
                .savetime(savetime)
                .barebone(barebone)
                .keycaps(keycaps)
                .design(design)
                .keyswitch(keyswitch)
                .build());
    }

    


}
