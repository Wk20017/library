package com.wk.service;

import com.wk.dao.SearchDao;
import com.wk.model.RecommendInfo;
import com.wk.model.SearchByKeyModel;
import com.wk.model.SearchByKeyResult;
import com.wk.vo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
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

    public HashMap<Integer, SearchByKeyModel> searchByKeywords(List<String> searchList){
        HashMap<Integer, SearchByKeyModel> resultMap = new HashMap<>();
        try {
            for (String searchWord : searchList) {
                System.out.println("查询词语: " + searchWord);
                List<Integer> keywordIds = searchDao.getKeywordId(searchWord);

                for (int keywordId : keywordIds){
                    List<SearchByKeyResult> results = searchDao.searchByKeywords(keywordId);
                    if (null != results) {
                        for (SearchByKeyResult item : results) {
                            int chapterId = item.getChapterId();//对应章节ID
                            float value = Float.parseFloat(item.getSimValue());//相关度值
                            String text = item.getText();//对应文本
                            System.out.println("chapterId="+chapterId);
                            int bookId = searchDao.getBookIdByChapterId(chapterId);
                            System.out.println("bookId="+bookId);
                            Book book = searchDao.getBookByBookId(bookId);
                            if (!resultMap.containsKey(chapterId)){
                                resultMap.put(chapterId, new SearchByKeyModel(value, text, book));
                            } else {
                                resultMap.get(chapterId).setValue(resultMap.get(chapterId).getValue()+value);
                            }
                        }
                    }
                }

            }
        } catch (Exception e){
            e.printStackTrace();
        }

        return resultMap;
    }

    public HashMap<ArrayList<String>, Float> keywordRecommend(List<String> searchList){
        HashMap<ArrayList<String>, Float> resultMap = new HashMap<>();
        try {
            for (String searchWord : searchList){
                System.out.println("查询词语: " + searchWord);
                List<Integer> keywordIds = searchDao.getKeywordId(searchWord);
                System.out.println(keywordIds);
                for (int keywordId : keywordIds){
                    List<RecommendInfo> keywordsInfo = searchDao.getRecommend(keywordId);
                    if (null != keywordsInfo){
                        for (RecommendInfo item : keywordsInfo) {
                            int keyword1Id = item.getKeyword1Id();
                            int keyword2Id = item.getKeyword2Id();
                            String keyword1 = searchDao.getKeywordById(keyword1Id);
                            String keyword2 = searchDao.getKeywordById(keyword2Id);
                            ArrayList<String> keywordList = new ArrayList<>();
                            keywordList.add(keyword1);
                            keywordList.add(keyword2);
                            float value = Float.parseFloat(item.getSimValue());
                            if (!resultMap.containsKey(keywordList)){
                                resultMap.put(keywordList, value);
                            } else {
                                resultMap.put(keywordList, resultMap.get(keywordList) + value);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultMap;
    }
}
