package com.ssg.gallery.account.helper;

import com.ssg.gallery.account.dto.AccountJoinRequest;
import com.ssg.gallery.account.dto.AccountLoginReqeust;
import com.ssg.gallery.account.etc.AccountConstants;
import com.ssg.gallery.common.util.HttpUtils;
import com.ssg.gallery.member.entity.Member;
import com.ssg.gallery.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class SessionAccountHelper implements AccountHelper {
    private final MemberService memberService;

    //회원 가입
    @Override
    public void join(AccountJoinRequest joinRequest) {
           memberService.save(joinRequest.getName(), joinRequest.getLoginId(), joinRequest.getLoginPw());
    }

    //로그인
    @Override
    public String login(AccountLoginReqeust loginReqeust, HttpServletRequest request, HttpServletResponse response) {
           Member member = memberService.find(loginReqeust.getLoginId(), loginReqeust.getLoginPw());

           if (member == null) {
               return null;
           }
         HttpUtils.setSession(request, AccountConstants.Member_ID_Name, member);
           return member.getLoginId();
    }

    //회원 아이디 조회

    @Override
    public Integer getMemberId(HttpServletRequest request) {
       Object memberId = HttpUtils.getSessionValue(request, AccountConstants.Member_ID_Name);
       if (memberId != null) {
            return  (int)memberId;
       }
       return null;
    }

    //로그인 상태 정보 확인
    @Override
    public boolean isLoggedIn(HttpServletRequest request) {
        return getMemberId(request) != null;
    }

    //로그아웃
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
         HttpUtils.removeSession(request, AccountConstants.Member_ID_Name);
    }
}
