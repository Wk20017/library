package com.wk.service;

import com.wk.dao.ManagerDao;
import com.wk.model.Msg;
import com.wk.vo.Book;
import com.wk.vo.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ManagerService {
    @Autowired(required = false)
    private ManagerDao managerDao;

    public Msg login(Manager manager) {
        if (manager.getPassword() != null) {
            String managername = manager.getManagername();
            String password = managerDao.queryPwdByManagername(managername);
            if (password != null && password.equals(manager.getPassword())) {
                return new Msg("200", "right", "");
            } else {
                return new Msg("400", "wrong", "");
            }
        } else {
            return new Msg("400", "密码不能为空！", "");
        }
    }

    public Msg addBook(Book book) {
        String bookname = book.getBookname();
        String author = book.getAuthor();
        String ISBN = book.getIsbn();
        String pressname = book.getPressname();
        String picture = book.getPicture();
        String file = book.getFile();
        //关键字
        List<String> keywords = Arrays.asList("test1", "test2");
        managerDao.addBook(bookname, author, ISBN, pressname, picture, file, keywords.toString());
        return new Msg("200", "添加成功！", "");
    }
}
