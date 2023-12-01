package top.kristina.controller;


import jakarta.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kristina.model.dto.UserDto;
import top.kristina.model.vo.LoginVo;
import top.kristina.service.UserService;

@RestController
@RequestMapping()
public class LoginController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public LoginVo login(@RequestBody @Validated UserDto user) {
        return  userService.login(user);
    }
}
