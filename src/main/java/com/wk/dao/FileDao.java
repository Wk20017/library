package com.wk.dao;

import org.apache.ibatis.annotations.Param;

public interface FileDao {
    public void addChapter(@Param("bookId") Integer bookId, @Param("chapterName") String chapterName, @Param("path") String path);

    public String getKeywords(@Param("keyword") String keyword);

    public void addKeywords(@Param("keywordId") Integer keywordId, @Param("keyword") String keyword);

    public void addSimw2f(@Param("keywordId") int keywordId, @Param("chapterId") int chapterId, @Param("simValue") String simValue);

    public void addSimw2w(@Param("keyword1Id") int keywordId, @Param("keyword2Id") int chapterId, @Param("simValue") String simValue);
}
