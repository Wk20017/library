package com.wk.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {
    private int bookId;
    private int userId;
    private String comment;
    private String acquaintance;
    private String lastTime;
    private String lastLocation;
}
