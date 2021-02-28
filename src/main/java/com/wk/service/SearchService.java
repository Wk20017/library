package com.wk.service;

import com.wk.dao.SearchDao;
import com.wk.model.Msg;
import com.wk.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    @Autowired(required = false)
    private SearchDao searchDao;

    public List<Book> searchWithoutKeywords(List<String> searchList){
        List<Book> result = new ArrayList<>();
        try {
            for (String searchWord : searchList){
                System.out.println("查询词语: " + searchWord);
                List<Book> book = searchDao.searchBookWithoutKeywords(searchWord);
                System.out.println(book);
//                if (null != book) {//去重，速度慢
//                    for (Book item : book){
//                        if (!result.contains(item)){
//                            result.add(item);
//                        }
//                    }
//                }
                if (null != book) {//不去重
                    result.addAll(book);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }

    public List<Book> searchWithKeywords(List<String> searchList){
        List<Book> result = new ArrayList<>();
        try {
            for (String searchWord : searchList){
                System.out.println("查询词语: " + searchWord);
                List<Book> book = searchDao.searchWithKeywords(searchWord);
                System.out.println(book);
//                if (null != book) {//去重，速度慢
//                    for (Book item : book){
//                        if (!result.contains(item)){
//                            result.add(item);
//                        }
//                    }
//                }
                if (null != book) {//不去重
                    result.addAll(book);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return result;
    }
}