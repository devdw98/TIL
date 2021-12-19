package dw.study.springbootapi.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    /*
    - JWT 토큰 없이 api 호출한 경우
    - 형식에 맞지 않거나 만료된 JWT 토큰으로 api 호출한 경우
    의 오류들 처리를 위해 예외 발생한 경우 /exception/entrypoint 로 포워딩 처리함.
     */

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.sendRedirect("/exception/entrypoint");
    }
}
