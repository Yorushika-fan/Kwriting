package top.kristina.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kristina.model.vo.UserInfo;
import top.kristina.service.UserService;

@RestController
public class UserController {


    @Resource
    private UserService userService;

    @GetMapping("/getUserInfo")
    public UserInfo getUserInfo() {
        return userService.getUserInfo();
    }


}
