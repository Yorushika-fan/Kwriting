package top.kristina.config;

import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.support.config.FastJsonConfig;
import com.alibaba.fastjson2.support.spring6.http.converter.FastJsonHttpMessageConverter;
import com.alibaba.fastjson2.support.spring6.webservlet.view.FastJsonJsonView;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 所有接口
                .allowedOriginPatterns("*") // 支持域
                .allowCredentials(true) // 支持cookie
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 支持方法
                .allowedHeaders("*")
                .exposedHeaders("*")
                .maxAge(3600);
    }

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOriginPattern("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowCredentials(true);
        config.setMaxAge(3600L);
        source.registerCorsConfiguration("/**", config);
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }


    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters){

        FastJsonConfig fastJsonConfig = getFastJsonConfig();
        fastJsonConfig.setWriterFeatures(
                //Long转String 防止精度丢失
                JSONWriter.Feature.WriteLongAsString,
                JSONWriter.Feature.PrettyFormat
        );

        // 2. 添加fastjson转换器
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<>();

        // 3. 添加支持的媒体类型
        supportedMediaTypes.add(MediaType.APPLICATION_JSON);
        supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
        supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
        supportedMediaTypes.add(MediaType.APPLICATION_PDF);
        supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
        supportedMediaTypes.add(MediaType.APPLICATION_XML);
        supportedMediaTypes.add(MediaType.IMAGE_GIF);
        supportedMediaTypes.add(MediaType.IMAGE_JPEG);
        supportedMediaTypes.add(MediaType.IMAGE_PNG);
        supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
        supportedMediaTypes.add(MediaType.TEXT_HTML);
        supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
        supportedMediaTypes.add(MediaType.TEXT_PLAIN);
        supportedMediaTypes.add(MediaType.TEXT_XML);

        converter.setSupportedMediaTypes(supportedMediaTypes);
        //4 将convert添加到converters
        converter.setFastJsonConfig(fastJsonConfig);
        converters.add(0,converter);
    }

    private static FastJsonConfig getFastJsonConfig() {
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setDateFormat("yyyy-MM-dd hh:mm:ss");
        fastJsonConfig.setCharset(StandardCharsets.UTF_8);
        fastJsonConfig.setWriterFeatures(
                JSONWriter.Feature.WriteNullListAsEmpty,
                //json格式化
                JSONWriter.Feature.PrettyFormat,
                //输出map中value为null的数据
                JSONWriter.Feature.WriteMapNullValue,
                //输出boolean 为 false
                JSONWriter.Feature.WriteNullBooleanAsFalse,
                //输出list 为 []
                JSONWriter.Feature.WriteNullListAsEmpty,
                //输出number 为 0
                JSONWriter.Feature.WriteNullNumberAsZero,
                //输出字符串 为 ""
                JSONWriter.Feature.WriteNullStringAsEmpty,
                //对map进行排序
                JSONWriter.Feature.MapSortField
        );
        return fastJsonConfig;
    }


    @Override
    public  void configureViewResolvers(ViewResolverRegistry registry){
        FastJsonJsonView fastJsonJsonView = new FastJsonJsonView();
        registry.enableContentNegotiation(fastJsonJsonView);
    }




}
