package com.example.news_feed.repository;

import com.example.news_feed.dto.CommentFullResponse;
import com.example.news_feed.persistence.tables.pojos.Comment;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Name;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.example.news_feed.persistence.tables.records.Tables.COMMENT;


@Repository
@RequiredArgsConstructor
public class CommentRepository {

    private final DSLContext dsl;

    public Integer insertOne(Comment comment) {
        return dsl.insertInto(
                        COMMENT,
                        COMMENT.COMMENTATOR,
                        COMMENT.BODY,
                        COMMENT.ITEM_ID
                )
                .values(
                        comment.getCommentator(),
                        comment.getBody(),
                        comment.getItemId()
                )
                .returning(COMMENT.ID)
                .fetchOne()
                .getValue(COMMENT.ID);
    }

    public boolean updateOne(Comment comment) {
        return dsl.update(COMMENT)
                .set(COMMENT.COMMENTATOR, comment.getCommentator())
                .set(COMMENT.BODY, comment.getBody())
                .where(COMMENT.ID.eq(comment.getId()))
                .execute() > 0;
    }

    public boolean deleteOne(int commentId) {
        return dsl.delete(COMMENT)
                .where(COMMENT.ID.eq(commentId))
                .execute() > 0;
    }

    public List<CommentFullResponse> findAllForItem(int itemId) {
        return dsl.select(COMMENT.ID,
                        COMMENT.COMMENTATOR,
                        COMMENT.BODY,
                        COMMENT.ITEM_ID)
                .from(COMMENT)
                .where(COMMENT.ITEM_ID.eq(itemId))
                .fetchInto(CommentFullResponse.class);
    }

    public Optional<CommentFullResponse> findOne(int commentId) {
        return Optional.ofNullable(dsl.selectFrom((Name) COMMENT)
                .where(COMMENT.ID.eq(commentId))
                .fetchOneInto(CommentFullResponse.class));
    }

}