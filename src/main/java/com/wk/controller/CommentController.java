package com.wk.controller;

import com.wk.model.Msg;
import com.wk.service.CommentService;
import com.wk.vo.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class CommentController {
    @Resource
    private CommentService commentService;

    @RequestMapping("comment/updateComment")//添加、更新评论
    @ResponseBody
    public Msg updateComment(@RequestBody Comment comment){
        if (commentService.selectComment(comment.getBookId(), comment.getUserId())){
            return commentService.updateComment(comment.getBookId(), comment.getUserId(), comment.getComment());
        } else {
            return commentService.insertComment(comment.getBookId(), comment.getUserId(), comment.getComment());
        }
    }

    @RequestMapping("comment/acquaintance")//添加、更新心得
    @ResponseBody
    public Msg updateAcquaintance(@RequestBody Comment comment){
        if (commentService.selectComment(comment.getBookId(), comment.getUserId())){
            return commentService.updateAcquaintance(comment.getBookId(), comment.getUserId(), comment.getAcquaintance());
        } else {
            return commentService.insertAcquaintance(comment.getBookId(), comment.getUserId(), comment.getAcquaintance());
        }
    }

    @RequestMapping("comment/lastInfo")//添加、更新日志
    @ResponseBody
    public Msg updateLastInfo(@RequestBody Comment comment){
        if (commentService.selectComment(comment.getBookId(), comment.getUserId())){
            return commentService.updateLastInfo(comment.getBookId(), comment.getUserId(), comment.getLastTime(), comment.getLastLocation());
        } else {
            return commentService.insertLastInfo(comment.getBookId(), comment.getUserId(), comment.getLastTime(), comment.getLastLocation());
        }
    }
}
