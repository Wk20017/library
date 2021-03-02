package com.wk.controller;


import com.wk.model.Msg;
import com.wk.service.UserService;
import com.wk.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("user/login")//用户登录
    @ResponseBody
    /*
    * username="",password=""
    * 或
    * email="",password=""
    * */
    public Msg login(@Valid @RequestBody User user){
        return userService.login(user);
    }

    @RequestMapping("user/signin")//用户注册
    @ResponseBody
    /*
     * email="",username="",password=""
     * */
    public Msg signin(@Valid @RequestBody User user){
        return userService.signin(user);
    }
}
