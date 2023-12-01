package top.kristina.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import top.kristina.model.entry.Config;
import top.kristina.service.ConfigService;
import top.kristina.mapper.ConfigMapper;
import org.springframework.stereotype.Service;

/**
* @author 24038
* @description 针对表【tb_config】的数据库操作Service实现
* @createDate 2023-11-20 16:30:22
*/
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config>
    implements ConfigService{

}




