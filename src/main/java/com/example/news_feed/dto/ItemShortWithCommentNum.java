package com.example.news_feed.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ItemShortWithCommentNum {

    private Integer id;
    private String title;
    private String body;
    private String author;
    private int commentNum;
}