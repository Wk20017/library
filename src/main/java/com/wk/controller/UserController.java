package com.wk.controller;


import com.wk.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("user/test")
    @ResponseBody
    public String test(String username){
//        System.out.println(username);
        return userService.getEmail(username);
    }
}
