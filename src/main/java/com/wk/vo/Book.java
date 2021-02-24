package com.wk.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private Integer bookId;
    private String bookname;
    private String author;
    private String isbn;
    private String pressname;
    private String keywords;
    private String picture;
    private String file;
}
