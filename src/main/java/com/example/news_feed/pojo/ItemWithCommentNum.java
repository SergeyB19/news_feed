package com.example.news_feed.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ItemWithCommentNum {

    private Integer id;
    private String title;
    private String body;
    private String author;
    private int commentNum;
}