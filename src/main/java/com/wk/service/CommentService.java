package com.wk.service;

import com.wk.dao.CommentDao;
import com.wk.model.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired(required = false)
    private CommentDao commentDao;

    public boolean selectComment(int bookId, int userId){
        return null != commentDao.selectComment(bookId, userId);
    }

    public Msg insertComment(int bookId, int userId, String comment){
        try {
            commentDao.insertComment(bookId, userId, comment);
            return new Msg("200", "评论添加成功！", "");
        } catch (Exception e) {
            e.printStackTrace();
            return new Msg("400", "评论添加失败！", "");
        }
    }

    public Msg updateComment(int bookId, int userId, String comment){
        try {
            commentDao.updateComment(bookId, userId, comment);
            return new Msg("200", "评论更新成功！", "");
        } catch (Exception e) {
            e.printStackTrace();
            return new Msg("400", "评论更新失败！", "");
        }
    }

    public Msg insertAcquaintance(int bookId, int userId, String acquaintance){
        try {
            commentDao.insertAcquaintance(bookId, userId, acquaintance);
            return new Msg("200", "心得添加成功！", "");
        } catch (Exception e) {
            e.printStackTrace();
            return new Msg("400", "心得添加失败！", "");
        }
    }

    public Msg updateAcquaintance(int bookId, int userId, String acquaintance){
        try {
            commentDao.updateAcquaintance(bookId, userId, acquaintance);
            return new Msg("200", "心得更新成功！", "");
        } catch (Exception e) {
            e.printStackTrace();
            return new Msg("400", "心得更新失败！", "");
        }
    }

    public Msg insertLastInfo(int bookId, int userId, String lastTime, String lastLocation){
        try {
            commentDao.insertLastInfo(bookId, userId, lastTime, lastLocation);
            return new Msg("200", "日志添加成功！", "");
        } catch (Exception e) {
            e.printStackTrace();
            return new Msg("400", "日志添加失败！", "");
        }
    }

    public Msg updateLastInfo(int bookId, int userId, String lastTime, String lastLocation){
        try {
            commentDao.updateLastInfo(bookId, userId, lastTime, lastLocation);
            return new Msg("200", "日志更新成功！", "");
        } catch (Exception e) {
            e.printStackTrace();
            return new Msg("400", "日志更新失败！", "");
        }
    }
}
