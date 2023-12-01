package top.kristina.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kristina.model.entry.Category;
import top.kristina.service.CategoryService;
import top.kristina.mapper.CategoryMapper;
import org.springframework.stereotype.Service;

/**
* @author 24038
* @description 针对表【tb_category】的数据库操作Service实现
* @createDate 2023-11-20 16:30:22
*/
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category>
    implements CategoryService{

}




