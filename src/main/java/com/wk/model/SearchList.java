package com.wk.model;

import com.wk.vo.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchList {
    //搜索词组
    private List<String> searchList;
}
