package com.ssg.gallery.member.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name="members")
public class Member {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50 , nullable = false)
    private String name;

    @Column(length = 50 , nullable = false , unique = true)
    private String loginId;

    @Column(length = 50 , nullable = false)
    private String loginPw;

    @Column(nullable = false , updatable = false)
    @CreationTimestamp   //회원 가입 시 별다른 시간 값이 넘어오지 않는다면 현재 시각을 값으로 할당한다.
    private LocalDateTime created;

    public Member() {}

    public Member(String name, String loginId, String loginPw) {
        this.name = name;
        this.loginId = loginId;
        this.loginPw = loginPw;
    }



}
