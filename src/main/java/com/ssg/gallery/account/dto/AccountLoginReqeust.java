package com.ssg.gallery.account.dto;

import lombok.Getter;
//로그인 시 회원의 정보 저장
@Getter
public class AccountLoginReqeust {
    private String loginId;
    private String loginPw;
}
