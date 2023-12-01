package top.kristina.service;


import top.kristina.model.dto.TagDto;
import top.kristina.model.entry.Tag;
import com.baomidou.mybatisplus.extension.service.IService;
import top.kristina.model.vo.TagVo;

import java.util.List;

/**
* @author 24038
* @description 针对表【tb_tag】的数据库操作Service
* @createDate 2023-11-20 16:30:22
*/
public interface TagService extends IService<Tag> {

    List<TagVo> getAllTags();

    void addTag(TagDto tag);

    void updateTag(TagDto tag);

    void deleteTag(Long id);
}
