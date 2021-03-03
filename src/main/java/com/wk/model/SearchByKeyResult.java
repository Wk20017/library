package com.wk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SearchByKeyResult {
    //通过关键词搜索结果
    private int simw2fId;
    private int keywordId;
    private int chapterId;
    private String simValue;
    private String text;
}
