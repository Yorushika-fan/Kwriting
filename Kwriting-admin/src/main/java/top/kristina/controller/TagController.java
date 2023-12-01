package top.kristina.controller;


import jakarta.annotation.Resource;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.kristina.model.dto.TagDto;
import top.kristina.model.vo.TagVo;
import top.kristina.service.TagService;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Resource
    private TagService tagService;

    /*
     * 获取所有标签

     */
    @GetMapping("/all")
    public List<TagVo> getAllTags() {
       return  tagService.getAllTags();
    }

    /*
     * 添加标签
     */
    @PostMapping()
    public void addTag(@RequestBody @Validated TagDto tag) {
        tagService.addTag(tag);
    }

    /**
     *
     * 更新标签
     * @param tag
     */
    @PutMapping
    public void updateTag(@RequestBody @Validated TagDto tag) {
        tagService.updateTag(tag);
    }

    /**
     *
     * 删除标签
     */
    @DeleteMapping("/{id}")
    public void deleteTag(@NotNull  @PathVariable("id")  Long id) {
        tagService.deleteTag(id);
    }



}
