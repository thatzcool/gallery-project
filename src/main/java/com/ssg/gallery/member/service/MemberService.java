package com.ssg.gallery.member.service;

import com.ssg.gallery.member.entity.Member;

public interface MemberService {

    //회원의 정보 저장
    void save(String name, String loginId, String loginPw);

    //회원의 정보 조회
    Member find(String loginId, String loginPw);
}
