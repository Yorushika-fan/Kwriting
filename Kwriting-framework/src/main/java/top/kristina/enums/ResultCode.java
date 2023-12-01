package top.kristina.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public enum ResultCode {
    SUCCESS(0, "ok"),
    PARAM_ERROR(400, "参数错误"),
    Login_ERROR_USERNAME(403, "用户不存在"),
    Login_ERROR_PASSWORD(402, "密码错误"),
    NEED_LOGIN(401,"需要登录"),
    NOT_FOUND(404, "资源不存在"),
    SERVER_ERROR(500, "服务器错误");


    private Integer code;
    private String msg;

    public static ResultCode getByCode(Integer code){
        return Arrays.stream(ResultCode.values())
                .filter(resultCode -> resultCode.getCode().equals(code)).findFirst().orElse(SUCCESS);
    }
}



