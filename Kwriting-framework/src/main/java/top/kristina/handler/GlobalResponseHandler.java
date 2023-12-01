package top.kristina.handler;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import top.kristina.common.ResponseResult;

import java.util.Map;


@RestControllerAdvice
@ResponseBody
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {


    @Value("${advice.result:true}")
    Boolean resultAdviceEnabled;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return resultAdviceEnabled &&!returnType.getDeclaringClass().getName().contains("OpenApi");
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        if (body instanceof ResponseResult || body instanceof Map){
            return body;
        }
        return ResponseResult.success(body);
    }
}
