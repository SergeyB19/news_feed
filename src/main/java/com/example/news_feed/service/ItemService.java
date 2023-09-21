package com.example.news_feed.service;

import com.example.news_feed.dto.*;

import com.example.news_feed.filter.ItemPageFilter;
import com.example.news_feed.page.SimplePage;
import org.springframework.data.domain.Sort;

/**
 * Defines a service layer of items
 */

public interface ItemService {

    ItemShortResponse save(ItemSaveRequest itemSaveRequest);

    ItemShortResponse update(ItemUpdateRequest itemUpdateRequest);

    SimplePage<ItemShortWithCommentNum> findPaginated(int page, int size, Sort sort, ItemPageFilter filter);

    ItemFullResponse findItem(int itemId);
}