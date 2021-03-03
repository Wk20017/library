package com.wk.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecommendInfo {
    private int simw2wId;
    private int keyword1Id;
    private int keyword2Id;
    private String simValue;
}
