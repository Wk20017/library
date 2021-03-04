package com.wk.controller;

import com.wk.model.Msg;
import com.wk.model.SearchByKeyModel;
import com.wk.model.SearchList;
import com.wk.service.SearchService;
import com.wk.vo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.*;

@Controller
public class SearchController {
    @Resource
    private SearchService searchService;

    @RequestMapping("searchBook/searchWithoutKeywords")//不根据关键词搜索
    @ResponseBody
    /*
    * searchList=["", ""]
    * */
    public Msg searchWithoutKeywords(@RequestBody SearchList searchList){
        List<Book> result = searchService.searchWithoutKeywords(searchList.getSearchList());
        if (result.isEmpty()){
            return new Msg("400", "没有查到!", "");
        } else {
            return new Msg("200", "查找成功!", result);
        }
    }

    @RequestMapping("searchBook/searchWithKeywords")//根据关键词搜索，使用mysql全文检索
    @ResponseBody
    public Msg searchWithKeywords(@RequestBody SearchList searchList){
        List<Book> result = searchService.searchWithKeywords(searchList.getSearchList());
        if (result.isEmpty()){
            return new Msg("400", "没有查到!", "");
        } else {
            return new Msg("200", "查找成功!", result);
        }
    }

    @RequestMapping("searchBook/recommend")//检索词推荐
    @ResponseBody
    public Msg keywordRecommend(@RequestBody SearchList searchList){
        Map<ArrayList<String>, Float> keywordsInfo = searchService.keywordRecommend(searchList.getSearchList());
        List<String> result = new ArrayList<>();
        if (keywordsInfo.isEmpty()){
            return new Msg("400", "没有查到!", "");
        } else {
            //按照相关度从大到小排序
            List<Map.Entry<ArrayList<String>, Float>> list = new ArrayList<>(keywordsInfo.entrySet());
            list.sort((o1, o2) -> o1.getValue().compareTo(o2.getValue()));
            for (Map.Entry<ArrayList<String>, Float> s : list)
            {
                result.add(s.getKey().get(1));
            }
            return new Msg("200", "查找成功!", result);
        }
    }

    @RequestMapping("searchBook/searchByKeywords")//关键词检索，按相关度大小排序
    @ResponseBody
    public Msg searchByKeywords(@RequestBody SearchList searchList){
        Map<Integer, SearchByKeyModel> resultMap = searchService.searchByKeywords(searchList.getSearchList());
        if (resultMap.isEmpty()){
            return new Msg("400", "没有查到!", "");
        } else {
            //按照相关度从大到小排序
            List<Map.Entry<Integer, SearchByKeyModel>> list = new ArrayList<>(resultMap.entrySet());
            list.sort((o1, o2) -> Float.compare(o2.getValue().getValue(), o1.getValue().getValue()));
//            for (Map.Entry<Integer, SearchByKeyModel> s : list)
//            {
//                System.out.println(s.getKey()+"--"+s.getValue());
//            }
            return new Msg("200", "查找成功!", list);//json格式 章节id：相关度值
        }
    }
}
