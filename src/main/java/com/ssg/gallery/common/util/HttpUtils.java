package com.ssg.gallery.common.util;

import jakarta.servlet.http.HttpServletRequest;

//세션 공통 작업
public class HttpUtils {

    //Http 세션데이터를 입력하는 메서드
    //매개변수로 HTTP 요청객체와 세션의 키, 세션의 값을 받는다. 후에 로그인 성공한 사용자의 정보를 저장할때 사용한다.
    public static void setSession(HttpServletRequest request, String key, Object value) {
        request.getSession().setAttribute(key, value);
    }

    //세션 값 조회
    public static Object getSessionValue(HttpServletRequest request, String key) {
        return request.getSession().getAttribute(key);
    }

    //세션 삭제
    public static void removeSession(HttpServletRequest request, String key) {
        request.getSession().removeAttribute(key);

    }


}
