package top.kristina.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import top.kristina.mapper.RoleMapper;
import top.kristina.mapper.UserMapper;
import top.kristina.mapper.UserRoleMapper;
import top.kristina.model.entry.LoginUser;
import top.kristina.model.entry.Role;
import top.kristina.model.entry.User;
import top.kristina.model.vo.RoleVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserMapper sysUserMapper;

    @Resource
    private RoleMapper sysRoleMapper;

    @Resource
    private UserRoleMapper sysUserRoleMapper;

    //    @Resource
//    private MenuMapper sysMenuMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);

        User user = sysUserMapper.selectOne(queryWrapper);

        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("用户不存在");
        }


        List<Long> roleIdList = sysUserRoleMapper.getAllRolesByUserId(user.getId());
        List<Role> roleList = sysRoleMapper.selectList(new LambdaQueryWrapper<Role>().in(Role::getId, roleIdList));

        user.setRoles(BeanUtil.copyToList(roleList, RoleVo.class));

//
//        if (UserConstant.USER_ADMIN.equals(user.getType())){
//            List<String> perms = sysMenuMapper.selectPermsByUserId(user.getId());
//            return new LoginUser(user,perms);
//        }

        return new LoginUser(user, null);
    }
}

