package com.example.news_feed.controller;

import com.example.news_feed.dto.*;
import com.example.news_feed.filter.ItemPageFilter;
import com.example.news_feed.page.SimplePage;
import com.example.news_feed.service.CommentService;
import com.example.news_feed.service.ItemService;
import com.example.news_feed.utils.UriConsts;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(UriConsts.API + UriConsts.NEWS)
public class ItemController {

    private final ItemService itemService;
    private final CommentService commentService;

    @PostMapping()
    public ResponseEntity<ItemShortResponse> createItem(
            @Valid @RequestBody ItemSaveRequest itemSaveRequest) {
        var itemShortResponse = itemService.save(itemSaveRequest);
        return new ResponseEntity<>(
                itemShortResponse,
                HttpStatus.OK
        );
    }

    @PutMapping()
    public ResponseEntity<ItemShortResponse> updateItem(
            @Valid @RequestBody ItemUpdateRequest itemUpdateRequest) {
        var itemShortResponse = itemService.update(itemUpdateRequest);
        return new ResponseEntity<>(
                itemShortResponse,
                HttpStatus.OK
        );
    }

    @GetMapping()
    public ResponseEntity<SimplePage<ItemShortWithCommentNum>> getItems(
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size,
            Sort sort,
            ItemPageFilter filter) {
        var resultPage = itemService.findPaginated(page, size, sort, filter);
        return new ResponseEntity<>(
                resultPage,
                HttpStatus.OK);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemFullResponse> getItem(@PathVariable("itemId") int itemId) {
        return new ResponseEntity<>(
                itemService.findItem(itemId),
                HttpStatus.OK);
    }

    @GetMapping("/{itemId}" + UriConsts.COMMENTS)
    public ResponseEntity<List<CommentFullResponse>> getComments(
            @PathVariable("itemId") int itemId) {
        var comments = commentService.findAllForItem(itemId);
        return new ResponseEntity<>(
                comments,
                HttpStatus.OK
        );
    }
}