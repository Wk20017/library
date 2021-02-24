package com.wk.dao;

import com.wk.vo.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SearchDao {
    List<Book> searchBookWithoutKeywords(@Param("searchWord") String searchWord);
}
