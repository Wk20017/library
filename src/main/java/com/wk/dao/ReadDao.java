package com.wk.dao;

import com.wk.vo.Chapters;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReadDao {
    List<Chapters> getAllChapters(@Param("bookId") int bookId);
}
