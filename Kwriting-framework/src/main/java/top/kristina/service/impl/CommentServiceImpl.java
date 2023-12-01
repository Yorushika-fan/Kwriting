package top.kristina.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kristina.model.entry.Comment;
import top.kristina.service.CommentService;
import top.kristina.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author 24038
* @description 针对表【tb_comment】的数据库操作Service实现
* @createDate 2023-11-20 16:30:22
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

}




