package com.wk.dao;

import org.apache.ibatis.annotations.Param;


public interface ManagerDao {
    String queryPwdByManagername(@Param("managername") String managername);

    void addBook(@Param("bookname") String bookname, @Param("author") String author, @Param("ISBN") String ISBN, @Param("pressname") String pressname, @Param("picture") String picture, @Param("file") String file, @Param("keywords") String keywords);
}
