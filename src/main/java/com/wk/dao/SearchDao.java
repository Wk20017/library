package com.wk.dao;

import com.wk.model.RecommendInfo;
import com.wk.model.SearchByKeyResult;
import com.wk.vo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchDao {
    List<Book> searchBookWithoutKeywords(@Param("searchWord") String searchWord);

    List<Book> searchWithKeywords(@Param("searchWord") String searchWord);

    List<Integer> getKeywordId(@Param("searchWord") String searchWord);

    List<SearchByKeyResult> searchByKeywords(@Param("keywordId") int keywordId);

    List<RecommendInfo> getRecommend(@Param("keywordId") int keywordId);

    String getKeywordById(@Param("keyword1Id") int keyword1Id);

    Book getBookByBookId(@Param("bookId") int bookId);

    int getBookIdByChapterId(@Param("chapterId") int chapterId);
}
