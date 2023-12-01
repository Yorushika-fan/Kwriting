package top.kristina.mapper;

import org.apache.ibatis.annotations.Param;
import top.kristina.model.entry.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 24038
* @description 针对表【tb_tag】的数据库操作Mapper
* @createDate 2023-11-20 16:30:22
* @Entity top.kristina.model.entry.Tag
*/
public interface TagMapper extends BaseMapper<Tag> {

    Tag getTagByName(@Param("name") String name);


}




