package top.kristina.common;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import top.kristina.constant.ResultTypeConstant;
import top.kristina.enums.ResultCode;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private int code;
    private String message;
    private String type;
    private T result;

    public static <T> ResponseResult<T> success(T data){
        ResponseResult<T> result = new ResponseResult<T>();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage(ResultCode.SUCCESS.getMsg());
        result.setType(ResultTypeConstant.SUCCESS);
        result.setResult(data);
        return result;
    }

    public static <T> ResponseResult<T> error(ResultCode resultCode,String msg){
        ResponseResult<T> result = new ResponseResult<T>();
        result.setCode(resultCode.getCode());
        result.setType(ResultTypeConstant.ERROR);
        result.setMessage(msg);
        return result;
    }

    public static <T> ResponseResult<T> error(ResultCode resultCode){
        ResponseResult<T> result = new ResponseResult<T>();
        result.setCode(resultCode.getCode());
        result.setType(ResultTypeConstant.ERROR);
        result.setMessage(resultCode.getMsg());
        return result;
    }

}
