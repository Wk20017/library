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

    @RequestMapping("read/currentChapter")//历史记录，当前章节或上次章节
    @ResponseBody
    public Msg getCurrentChapters(@RequestParam("bookId") int bookId, @RequestParam("userId") int userId){
        try {
            Chapters currentChapter = readService.getCurrentChapter(bookId, userId);
            return new Msg("200", "查询成功", currentChapter);
        } catch (Exception e) {
            e.printStackTrace();
            return new Msg("400", "查询失败", "");
        }
    }

    @RequestMapping("read/getChapterByChapterId")//获取对应图书章节
    @ResponseBody
    public Msg getChapterByChapterId(@RequestParam("chapterId") int chapterId){
        try {
            Chapters chapter = readService.getChapterByChapterId(chapterId);
            return new Msg("200", "成功返回章节信息！", chapter);
        } catch (Exception e) {
            e.printStackTrace();
            return new Msg("400", "没有该章节！", "");
        }
    }
}
