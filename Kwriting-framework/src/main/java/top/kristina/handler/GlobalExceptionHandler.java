package top.kristina.handler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.kristina.common.ResponseResult;
import top.kristina.enums.ResultCode;
import javax.security.auth.login.LoginException;
import java.util.Arrays;
import java.util.Objects;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult<String> methodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error(String.valueOf(e));
        if (Objects.isNull(e.getBindingResult().getFieldError()))
            return ResponseResult.error(ResultCode.PARAM_ERROR);

        return ResponseResult.error(ResultCode.PARAM_ERROR, e.getBindingResult().getFieldError().getDefaultMessage());
    }
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseResult<String> IllegalArgumentException(IllegalArgumentException e){

        log.error(Arrays.toString(e.getStackTrace()));
        if (Objects.isNull(e.getMessage()))
            return ResponseResult.error(ResultCode.PARAM_ERROR);
        return ResponseResult.error(ResultCode.PARAM_ERROR, e.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseResult<String> BadCredentialsException(BadCredentialsException e){
        return ResponseResult.error(ResultCode.Login_ERROR_PASSWORD);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseResult<String> UsernameNotFoundException(UsernameNotFoundException e){
        return ResponseResult.error(ResultCode.Login_ERROR_USERNAME);
    }
    @ExceptionHandler(LoginException.class)
    public ResponseResult<String> LoginException(LoginException e){
        return ResponseResult.error(ResultCode.Login_ERROR_USERNAME, e.getMessage());
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    public ResponseResult<String> InsufficientAuthenticationException(InsufficientAuthenticationException e){
        return ResponseResult.error(ResultCode.NEED_LOGIN);
    }

}

