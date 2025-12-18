package com.example.demo.controller;

import com.example.demo.pojo.Token;
import com.example.demo.pojo.User;
import com.example.demo.service.impl.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public LoginController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @RequestMapping("/authorizations")
    public Token userCheck(@RequestBody User user) {
        Token token = userServiceImpl.checkUser(user.getUsername(), user.getPassword());
        System.out.println("传过来的用户名、密码是：" + user.getUsername() + " " + user.getPassword());
        return token;
    }
}
