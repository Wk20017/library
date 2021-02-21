package com.wk.dao;

import com.wk.vo.User;
import org.apache.ibatis.annotations.Param;


public interface UserDao {
    String queryUserEmail(@Param("username") String username);
}
