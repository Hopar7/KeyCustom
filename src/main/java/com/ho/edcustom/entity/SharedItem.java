package com.ho.edcustom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shareitems")
public class SharedItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String email;

    String savetime;

    String barebonecolor; //베어본

    String keyboardtype;

    String keycapcolor;

    String design;//디자인

    String switchcolor;  //스위치
}
