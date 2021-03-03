package com.wk.controller;

import com.wk.model.Msg;
import com.wk.service.ReadService;
import com.wk.vo.Chapters;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class ReadController {
    @Resource
    private ReadService readService;

    @RequestMapping("read/getAllChapters")//获取所有章节
    @ResponseBody
    public Msg getAllChapters(@RequestParam("bookId") int bookId){
        try {
            List<Chapters> result = readService.getAllChapters(bookId);
            return new Msg("200", "成功返回章节", result);
        } catch (Exception e) {
            e.printStackTrace();
            return new Msg("400", "返回章节失败", "");
        }

    }
}