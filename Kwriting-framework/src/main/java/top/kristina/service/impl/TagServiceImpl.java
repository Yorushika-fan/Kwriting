package top.kristina.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import top.kristina.constant.CommonStatus;
import top.kristina.model.dto.TagDto;
import top.kristina.model.entry.Tag;
import top.kristina.model.vo.TagVo;
import top.kristina.service.TagService;
import top.kristina.mapper.TagMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author 24038
 * @description 针对表【tb_tag】的数据库操作Service实现
 * @createDate 2023-11-20 16:30:22
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
        implements TagService {


    @Resource
    private TagMapper tagMapper;

    @Override
    public List<TagVo> getAllTags() {
        List<Tag> tags = this.list().stream()
                .filter(tag -> tag.getIsDeleted() != CommonStatus.DELETED).toList();
        return BeanUtil.copyToList(tags, TagVo.class);
    }

    @Override
    public void addTag(TagDto tag) {
        //判断标签是否存
        Tag temTag = tagMapper.getTagByName(tag.getName());
        if (Objects.isNull(temTag)) {
            this.save(BeanUtil.copyProperties(tag, Tag.class));
        } else if (temTag.getIsDeleted() == CommonStatus.DELETED) {
            temTag.setIsDeleted(CommonStatus.NORMAL);
            this.updateById(temTag);
        }

    }

    @Override
    public void updateTag(TagDto tag) {

    }

    @Override
    public void deleteTag(Long id) {

        if (Objects.isNull(id)){
            throw new IllegalArgumentException("id不能为空");
        }
        Tag tag = this.getById(id);
        if (Objects.isNull(tag)){
            throw new IllegalArgumentException("该标签不存在");
        }
        tag.setIsDeleted(CommonStatus.DELETED);
        this.updateById(tag);
    }
}




