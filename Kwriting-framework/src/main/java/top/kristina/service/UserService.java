package top.kristina.service;

import top.kristina.model.dto.UserDto;
import top.kristina.model.entry.User;
import com.baomidou.mybatisplus.extension.service.IService;
import top.kristina.model.vo.LoginVo;
import top.kristina.model.vo.UserInfo;
import top.kristina.model.vo.UserVo;

/**
* @author 24038
* @description 针对表【tb_user】的数据库操作Service
* @createDate 2023-11-20 16:49:27
*/
public interface UserService extends IService<User> {

    LoginVo login(UserDto user);

    UserInfo getUserInfo();
}
