package com.example.handleError.repository;

import com.example.handleError.entity.Comment;

import java.util.List;

public interface CommentCustomRepository {
    List<Comment> fetchJoin();
    List<Comment> innerJoin();
}
