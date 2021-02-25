package com.wk.dao;

import org.apache.ibatis.annotations.Param;

public interface CommentDao {
    String selectComment(@Param("bookId") int bookId, @Param("userId") int userId);

    void insertComment(@Param("bookId") int bookId, @Param("userId") int userId, @Param("comment") String comment);

    void updateComment(@Param("bookId") int bookId, @Param("userId") int userId, @Param("comment") String comment);

    void insertAcquaintance(@Param("bookId") int bookId, @Param("userId") int userId, @Param("acquaintance") String acquaintance);

    void updateAcquaintance(@Param("bookId") int bookId, @Param("userId") int userId, @Param("acquaintance") String acquaintance);

    void insertLastInfo(@Param("bookId") int bookId, @Param("userId") int userId, @Param("lastTime") String lastTime, @Param("lastLocation") String lastLocation);

    void updateLastInfo(@Param("bookId") int bookId, @Param("userId") int userId, @Param("lastTime") String lastTime, @Param("lastLocation") String lastLocation);
}
