package com.ho.edcustom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    //String profile; //사진 할까싶은데 일단 생성

    //@Column(unique = true)
    //String nickName;

    @Column(unique = true)
    String email;

    String password;



//    public Member updatePassword(String newPassword)
//    {
//        this.password =newPassword;
//        return this;
//    }
}
