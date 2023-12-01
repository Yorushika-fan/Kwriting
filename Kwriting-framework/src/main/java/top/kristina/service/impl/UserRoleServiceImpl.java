package top.kristina.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kristina.model.entry.UserRole;
import top.kristina.service.UserRoleService;
import top.kristina.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author 24038
* @description 针对表【tb_user_role】的数据库操作Service实现
* @createDate 2023-11-20 16:49:27
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




