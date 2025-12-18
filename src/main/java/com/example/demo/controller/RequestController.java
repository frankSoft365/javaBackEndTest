package com.example.demo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {

    @RequestMapping("/request")
    public String request(HttpServletRequest request) {
        // 请求方式
        String method = request.getMethod();
        System.out.println("请求方式 : " + method);
        // 请求路径
        String url = request.getRequestURL().toString();
        System.out.println("请求路径 : " + url);
        String uri = request.getRequestURI();
        System.out.println("请求资源 : " + uri);
        // 协议
        String protocol = request.getProtocol();
        System.out.println("协议 : " + protocol);
        // 请求体
        String accept = request.getHeader("Accept");
        System.out.println("Accept : " + accept);
        String cookie = request.getHeader("Cookie");
        System.out.println("Cookie : " + cookie);
        // 请求参数
        String name = request.getParameter("name");
        System.out.println("name : " + name);
        String age = request.getParameter("age");
        System.out.println("age : " + age);

        return "ok";
    }
}
