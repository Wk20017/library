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
    private int simw2fId;
    private int keywordId;
    private int chapterId;
    private String simValue;
}
