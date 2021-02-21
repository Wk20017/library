package com.wk.dao;

import com.wk.vo.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {
    String queryPwdByUsername(@Param("username") String username);

    String queryPwdByEmail(@Param("email") String email);

    void addUser(@Param("email") String email, @Param("username") String username, @Param("password") String password);
}
