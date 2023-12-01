package top.kristina.mapper;

import org.apache.ibatis.annotations.Param;
import top.kristina.model.entry.UserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author 24038
* @description 针对表【tb_user_role】的数据库操作Mapper
* @createDate 2023-11-20 16:49:27
* @Entity top.kristina.model.entry.UserRole
*/
public interface UserRoleMapper extends BaseMapper<UserRole> {

    List<Long> getAllRolesByUserId(@Param("id") Long id);
}




