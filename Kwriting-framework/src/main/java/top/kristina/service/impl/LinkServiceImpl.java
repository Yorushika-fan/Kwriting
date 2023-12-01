package top.kristina.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kristina.model.entry.Link;
import top.kristina.service.LinkService;
import top.kristina.mapper.LinkMapper;
import org.springframework.stereotype.Service;

/**
* @author 24038
* @description 针对表【tb_link】的数据库操作Service实现
* @createDate 2023-11-20 16:30:22
*/
@Service
public class LinkServiceImpl extends ServiceImpl<LinkMapper, Link>
    implements LinkService{

}




