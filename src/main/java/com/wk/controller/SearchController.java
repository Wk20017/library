package com.wk.controller;

import com.wk.model.Msg;
import com.wk.model.SearchList;
import com.wk.service.SearchService;
import com.wk.vo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {
    @Resource
    private SearchService searchService;

    @RequestMapping("searchBook/searchWithoutKeywords")
    @ResponseBody
    public Msg searchWithoutKeywords(@RequestBody SearchList searchList){
        List<Book> result = searchService.searchWithoutKeywords(searchList.getSearchList());
        if (result.isEmpty()){
            return new Msg("400", "没有查到!", "");
        } else {
            return new Msg("200", "查找成功!", result);
        }
    }
}
