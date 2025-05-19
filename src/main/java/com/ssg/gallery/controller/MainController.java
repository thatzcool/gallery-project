package com.ssg.gallery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController    //RestController 역할임을 표시
@RequestMapping("/v1")   //모든 HTTP 메서드의 요청을 매핑하기 위한 애너테이션. 연결 경로 값으로 버전을 의미하는 /v1 정의함
public class MainController {
    @GetMapping("/api/greeting")
    public String greeting() {
        return "Hello Spring Boot!";
    }

}
