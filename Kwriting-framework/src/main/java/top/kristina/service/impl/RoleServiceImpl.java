package top.kristina.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kristina.model.entry.Role;
import top.kristina.service.RoleService;
import top.kristina.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author 24038
* @description 针对表【tb_role】的数据库操作Service实现
* @createDate 2023-11-20 16:30:22
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




