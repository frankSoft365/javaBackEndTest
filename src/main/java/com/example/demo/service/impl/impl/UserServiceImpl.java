package com.example.demo.service.impl.impl;

import com.example.demo.dao.impl.UserDaoImpl;
import com.example.demo.pojo.Token;
import com.example.demo.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserDaoImpl userDaoImpl;

    @Autowired
    public UserServiceImpl(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    public Token checkUser(String username, String password) {
        Integer count = userDaoImpl.checkUser(username, password);
        Token token = new Token();
        if (count >= 1) {
            token.setLogin(true);
            token.setToken("hdjshakhfsahdakjfkahfhka");
            return token;
        }
        token.setLogin(false);
        token.setToken("");
        return token;
    }
}
