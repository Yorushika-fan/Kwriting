package top.kristina.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import top.kristina.constant.JwtConstant;
import top.kristina.constant.RedisBussesConstant;
import top.kristina.model.dto.UserDto;
import top.kristina.model.entry.LoginUser;
import top.kristina.model.entry.User;
import top.kristina.model.vo.LoginVo;
import top.kristina.model.vo.UserInfo;
import top.kristina.model.vo.UserVo;
import top.kristina.service.UserService;
import top.kristina.mapper.UserMapper;
import org.springframework.stereotype.Service;
import top.kristina.utils.RedisUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
* @author 24038
* @description 针对表【tb_user】的数据库操作Service实现
* @createDate 2023-11-20 16:49:27
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisUtil  redisCache;

    @Override
    public LoginVo login(UserDto user) {
        //登录验证
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

        Authentication authenticate = authenticationManager.authenticate(token);
        LoginUser loginuser = (LoginUser) authenticate.getPrincipal();
        Long id = loginuser.getUser().getId();

        Map<String, Object> map = new HashMap<String, Object>() {
            private static final long serialVersionUID = 1L;
            {
                put(JwtConstant.USER_ID, id.toString());
            }
        };
        String jwt = JWTUtil.createToken(map, JwtConstant.KEY.getBytes());

        redisCache.setCacheObject(RedisBussesConstant.ADMIN_USER_LOGIN + id.toString(), loginuser, 30, TimeUnit.MINUTES);
        return BeanUtil.copyProperties(loginuser.getUser(), LoginVo.class).setToken(jwt);

    }

    @Override
    public UserInfo getUserInfo() {

        return null;
    }
}




