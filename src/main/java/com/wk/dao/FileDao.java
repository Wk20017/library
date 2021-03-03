package com.wk.dao;

import org.apache.ibatis.annotations.Param;

public interface FileDao {
    void addChapter(@Param("bookId") Integer bookId, @Param("chapterName") String chapterName, @Param("path") String path);

    String getKeywords(@Param("keyword") String keyword);

    void addKeywords(@Param("keywordId") Integer keywordId, @Param("keyword") String keyword);

    void addSimw2f(@Param("keywordId") int keywordId, @Param("chapterId") int chapterId, @Param("simValue") String simValue);

    void addSimw2w(@Param("keyword1Id") int keywordId, @Param("keyword2Id") int chapterId, @Param("simValue") String simValue);

    String getKeyword(@Param("searchWord") String searchWord);

    void addText(@Param("keywordId") int keywordId, @Param("chapterId") int chapterId, @Param("text") String text);
}
