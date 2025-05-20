package com.ssg.gallery.account.dto;

import lombok.Getter;
import lombok.Setter;

//회원 가입 시 회원의 가입 정보를 저장
@Getter
@Setter
public class AccountJoinRequest {

       private String name;
       private String loginId;
       private String loginPw;
}
