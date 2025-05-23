package com.ssg.gallery.account.etc;

public class AccountConstants {
     //회원 아이디 이름 : 추후에 구현할 기능에서 반복적으로 사용될 회원아이디의 이름을 정의한 문자열 상수
     public static final String Member_ID_Name = "memberId";

     public static final String ACCESS_TOKEN_NAME = "accessToken";

     public static final String REFRESH_TOKEN_NAME = "refreshToken";

     public static final int ACCESS_TOKEN_EXP_MIN = 1;    //1분

     public static final int REFRESH_TOKEN_EXP_MIN = 60*24;   //24시간
}
