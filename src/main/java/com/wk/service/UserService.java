package com.wk.service;


import com.wk.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired(required = false)
    private UserDao userDao;

    public String getEmail(String username){
        return userDao.queryUserEmail(username);
    }
}
