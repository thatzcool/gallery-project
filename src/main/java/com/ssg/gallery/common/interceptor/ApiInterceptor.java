package com.ssg.gallery.common.interceptor;

import com.ssg.gallery.account.helper.AccountHelper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component   //스프링컨테이너에서 관리하는 컴포넌트임을 나타냄
@RequiredArgsConstructor
public class ApiInterceptor implements HandlerInterceptor {

    private final AccountHelper accountHelper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //만약 로그인 회원 아이디가 없다면
            if(accountHelper.getMemberId(request) == null) {
                response.setStatus(401);
                return false;
            }

            String origin = request.getHeader("Origin");
            if(origin != null && origin.contains("localhost:5173")) {
                  response.sendError(HttpServletResponse.SC_FORBIDDEN);
                  return false;
            }
        return true;
    }
}
