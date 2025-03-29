package com.ho.edcustom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shareitems")
@SuperBuilder(toBuilder = true)
public class SharedItem extends BaseItem{

    String sharedBy;


    //int liked 좋아요 추가
    //String
}
