package com.wk.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Chapters {
    private int chapterId;
    private String chapterName;
    private String chapterPath;
    private int bookId;
}
