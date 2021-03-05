package com.wk.dao;

import com.wk.vo.Chapters;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReadDao {
    List<Chapters> getAllChapters(@Param("bookId") int bookId);

    Integer getLastLocation(@Param("bookId") int bookId, @Param("userId") int userId);

    Chapters getChapterByChapterId(@Param("chapterId") Integer chapterId);
}
