package com.ssg.gallery.account.controller;


import ch.qos.logback.core.util.StringUtil;
import com.ssg.gallery.account.dto.AccountJoinRequest;
import com.ssg.gallery.account.dto.AccountLoginReqeust;
import com.ssg.gallery.account.helper.AccountHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class AccountController {
    private final AccountHelper accountHelper;

    @PostMapping("/api/account/join")
    public ResponseEntity<?> join(@RequestBody AccountJoinRequest request) {
        if (!StringUtils.hasLength(request.getName()) || !StringUtils.hasLength(request.getLoginId()) || !StringUtils.hasLength(request.getLoginPw())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        accountHelper.join(request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/account/login")
    public ResponseEntity<?> login(HttpServletRequest request, HttpServletResponse response, @RequestBody AccountLoginReqeust loginReq) {
        if (!StringUtils.hasLength(loginReq.getLoginId()) || !StringUtils.hasLength(loginReq.getLoginPw())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

       String output = accountHelper.login(loginReq, request, response);

        if (output == null) {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(output, HttpStatus.OK);
    }

    //로그아웃
    @PostMapping("/api/account/logout")
    public ResponseEntity<?> logout(HttpServletRequest request, HttpServletResponse response) {
        accountHelper.logout(request, response);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //로그인 상태 확인
    @GetMapping("/api/account/check")
    public ResponseEntity<?> check(HttpServletRequest request) {
        return new ResponseEntity<>(accountHelper.isLoggedIn(request), HttpStatus.OK);
    }


}
