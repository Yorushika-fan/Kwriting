package top.kristina.filter;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.alibaba.fastjson2.JSON;
import io.netty.util.internal.StringUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import top.kristina.common.ResponseResult;
import top.kristina.constant.JwtConstant;
import top.kristina.constant.RedisBussesConstant;
import top.kristina.constant.SecurityConstant;
import top.kristina.enums.ResultCode;
import top.kristina.model.entry.LoginUser;
import top.kristina.utils.RedisUtil;
import top.kristina.utils.WebUtil;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Resource
    private RedisUtil redisCache;
    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull  HttpServletResponse response,
                                    @NonNull FilterChain filterChain) throws ServletException, IOException {

        //获取token
        final String token = request.getHeader(SecurityConstant.ADMIN_AUTH_TOKEN );

        //没有token直接放行下一步处理
        if (StringUtil.isNullOrEmpty(token)){
            filterChain.doFilter(request,response);
            return;
        }

        //验证token合法性
        if (!JWTUtil.verify(token, JwtConstant.KEY.getBytes())){
            String result = JSON.toJSONString(ResponseResult.error(ResultCode.NEED_LOGIN));
            WebUtil.renderString(response,result);
        }

        //解析token
        final JWT jwt = JWTUtil.parseToken(token);
        Object uid = jwt.getPayload(JwtConstant.USER_ID);
        LoginUser loginUser = redisCache.getCacheObject(RedisBussesConstant.ADMIN_USER_LOGIN + uid.toString());
        SecurityContext securityContext = SecurityContextHolder.getContext();

        //登录过期
        if (Objects.isNull(loginUser )){
            String result = JSON.toJSONString(ResponseResult.error(ResultCode.NEED_LOGIN));
            WebUtil.renderString(response,result);
            return;
        }

        //刷新令牌过期时间
        redisCache.setCacheObject(RedisBussesConstant.ADMIN_USER_LOGIN + uid.toString(),loginUser,30, TimeUnit.MINUTES);
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginUser, null, null);
        securityContext.setAuthentication(authenticationToken);

        filterChain.doFilter(request,response);

    }





}

