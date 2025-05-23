package com.ssg.gallery.common.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

    //쿠키 생성  : 쿠키를 응답객체에 입력하는 메서드 ,
    public static void setCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setHttpOnly(true);   // 해당 쿠키를 서버에서만 접근 가능하도록 설정
        cookie.setPath("/");

        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }
        response.addCookie(cookie);
    }


    //쿠키 조회
    public static String getCookie(HttpServletRequest request, String name) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    return cookie.getValue();
                }
            }
        }
        return null;
    }


    //쿠키 삭제
   public static void removeCookie(HttpServletResponse response, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
   }

   //토큰 조회  : Bearer Oauth2.0 인가 프레임워크에서 사용하는 토큰의 이름
    public static String getBearerToken(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization");
        if(authToken != null && authToken.startsWith("Bearer ")) {
            return authToken.replace("Bearer ", "").trim();
        }
        return null;
    }



}
