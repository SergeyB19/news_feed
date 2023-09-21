package com.example.news_feed.persistence.tables.dao;

/*
 * This file is generated by jOOQ.
 */


import java.util.List;

import org.jooq.Configuration;


import static org.yaml.snakeyaml.events.Event.ID.Comment;


/**
 * Comment on the news
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class CommentDao extends DAOImpl<CommentRecord, com.example.news_feed.persistence.tables.pojos.Comment, Integer> {

    /**
     * Create a new CommentDao without any configuration
     */
    public CommentDao() {
        super(Comment.COMMENT, com.example.news_feed.persistence.tables.pojos.Comment.class);
    }

    /**
     * Create a new CommentDao with an attached configuration
     */
    public CommentDao(Configuration configuration) {
        super(Comment.COMMENT, com.example.news_feed.persistence.tables.pojos.Comment.class, configuration);
    }

    @Override
    public Integer getId(com.example.news_feed.persistence.tables.pojos.Comment object) {
        return object.getId();
    }

    /**
     * Fetch records that have <code>id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.example.news_feed.persistence.tables.pojos.Comment> fetchRangeOfId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Comment.COMMENT.ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>id IN (values)</code>
     */
    public List<com.example.news_feed.persistence.tables.pojos.Comment> fetchById(Integer... values) {
        return fetch(Comment.COMMENT.ID, values);
    }

    /**
     * Fetch a unique record that has <code>id = value</code>
     */
    public com.example.news_feed.persistence.tables.pojos.Comment fetchOneById(Integer value) {
        return fetchOne(Comment.COMMENT.ID, value);
    }

    /**
     * Fetch records that have <code>commentator BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.example.news_feed.persistence.tables.pojos.Comment> fetchRangeOfCommentator(String lowerInclusive, String upperInclusive) {
        return fetchRange(Comment.COMMENT.COMMENTATOR, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>commentator IN (values)</code>
     */
    public List<com.example.news_feed.persistence.tables.pojos.Comment> fetchByCommentator(String... values) {
        return fetch(Comment.COMMENT.COMMENTATOR, values);
    }

    /**
     * Fetch records that have <code>body BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.example.news_feed.persistence.tables.pojos.Comment> fetchRangeOfBody(String lowerInclusive, String upperInclusive) {
        return fetchRange(Comment.COMMENT.BODY, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>body IN (values)</code>
     */
    public List<com.example.news_feed.persistence.tables.pojos.Comment> fetchByBody(String... values) {
        return fetch(Comment.COMMENT.BODY, values);
    }

    /**
     * Fetch records that have <code>item_id BETWEEN lowerInclusive AND upperInclusive</code>
     */
    public List<com.example.news_feed.persistence.tables.pojos.Comment> fetchRangeOfItemId(Integer lowerInclusive, Integer upperInclusive) {
        return fetchRange(Comment.COMMENT.ITEM_ID, lowerInclusive, upperInclusive);
    }

    /**
     * Fetch records that have <code>item_id IN (values)</code>
     */
    public List<com.example.news_feed.persistence.tables.pojos.Comment> fetchByItemId(Integer... values) {
        return fetch(Comment.COMMENT.ITEM_ID, values);
    }
}