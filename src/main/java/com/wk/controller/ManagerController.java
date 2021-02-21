package com.wk.controller;

import com.wk.model.Msg;
import com.wk.service.ManagerService;
import com.wk.vo.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class ManagerController {
    @Resource
    private ManagerService managerService;

    @RequestMapping("manager/login")
    @ResponseBody
    public Msg login(@RequestBody Manager manager){
        return managerService.login(manager);
    }
}
