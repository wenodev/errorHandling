package com.example.handleError.repository;

import com.example.handleError.entity.Comment;
import com.example.handleError.entity.CommentPostData;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.handleError.entity.QComment.comment;
import static com.example.handleError.entity.QPost.post;

@Repository
public class CommentCustomRepositoryImpl implements CommentCustomRepository{

    private final JPAQueryFactory jpaQueryFactory;

    public CommentCustomRepositoryImpl(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public List<Comment> fetchJoin() {
        return jpaQueryFactory.select(comment)
                .from(comment)
                .innerJoin(comment.post, post)
                .fetchJoin()
                .fetch();
    }

    @Override
    public List<Comment> innerJoin() {
        return jpaQueryFactory.select(comment)
                .from(comment)
                .innerJoin(comment.post, post)
                .fetch();
    }
}
