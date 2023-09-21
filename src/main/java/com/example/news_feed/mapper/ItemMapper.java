package com.example.news_feed.mapper;

import com.example.news_feed.dto.ItemSaveRequest;
import com.example.news_feed.dto.ItemShortResponse;
import com.example.news_feed.dto.ItemShortWithCommentNum;
import com.example.news_feed.dto.ItemUpdateRequest;
import com.example.news_feed.persistence.tables.pojos.Item;
import com.example.news_feed.pojo.ItemWithCommentNum;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    /**
     * Convert entering Item to be saved to a POJO version
     */
    public Item toEntity(ItemSaveRequest itemSaveRequest) {
        return new Item()
                .setTitle(itemSaveRequest.getTitle())
                .setBody(itemSaveRequest.getBody())
                .setAuthor(itemSaveRequest.getAuthor());
    }

    /**
     * Convert entering Item to be saved to a short version
     */
    public ItemShortResponse toItemShortResponse(ItemSaveRequest itemSaveRequest, int id) {
        var shortDto = new ItemShortResponse();
        shortDto.setId(id)
                .setTitle(itemSaveRequest.getTitle())
                .setBody(cutTheBody(itemSaveRequest.getBody()))
                .setAuthor(itemSaveRequest.getAuthor());
        return shortDto;
    }

    /**
     * Convert entering Item to be updated to a short version
     */
    public ItemShortResponse toItemShortResponse(ItemUpdateRequest itemUpdateRequest) {
        return new ItemShortResponse()
                .setId(itemUpdateRequest.getId())
                .setTitle(itemUpdateRequest.getTitle())
                .setBody(cutTheBody(itemUpdateRequest.getBody()))
                .setAuthor(itemUpdateRequest.getAuthor());
    }

    /**
     * Convert POJO Item with commentaries number to a short version
     */
    public ItemShortWithCommentNum toItemShortCommentNumResponse(ItemWithCommentNum item) {
        return new ItemShortWithCommentNum()
                .setId(item.getId())
                .setTitle(item.getTitle())
                .setBody(cutTheBody(item.getBody()))
                .setAuthor(item.getAuthor())
                .setCommentNum(item.getCommentNum());
    }

    /**
     * Convert entering Item to be updated to a short version
     */
    public Item toUpdateEntity(ItemUpdateRequest itemUpdateRequest) {
        return new Item()
                .setId(itemUpdateRequest.getId())
                .setTitle(itemUpdateRequest.getTitle())
                .setBody(itemUpdateRequest.getBody())
                .setAuthor(itemUpdateRequest.getAuthor());
    }

    /**
     * Cutting text of item to a short version
     */
    private String cutTheBody(String body) {
        return body.length() > 50 ? body.substring(0, 50) : body;
    }
}