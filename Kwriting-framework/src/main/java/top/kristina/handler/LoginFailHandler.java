package top.kristina.handler;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import top.kristina.common.ResponseResult;
import top.kristina.enums.ResultCode;
import top.kristina.utils.WebUtil;

import java.io.IOException;

@Component
public class LoginFailHandler implements AuthenticationEntryPoint {


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        WebUtil.renderString(response, JSON.toJSONString(ResponseResult.error(ResultCode.NEED_LOGIN)));

    }
}
