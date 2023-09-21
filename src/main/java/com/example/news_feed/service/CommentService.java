package com.example.news_feed.service;

import com.example.news_feed.dto.CommentFullResponse;
import com.example.news_feed.dto.CommentSaveRequest;
import com.example.news_feed.dto.CommentShortResponse;
import com.example.news_feed.dto.CommentUpdateRequest;

import java.util.List;

public interface CommentService {

    CommentShortResponse save(CommentSaveRequest itemSaveRequest);

    CommentShortResponse update(CommentUpdateRequest itemUpdateRequest);

    void delete(int commentId);

    List<CommentFullResponse> findAllForItem(int itemId);

    CommentFullResponse findOne(int commentId);
}