package com.example.handleError.repository;

import com.example.handleError.entity.Post;

import java.util.List;

public interface PostCustomRepository {
    List<Post> findAllInnerFetchJoin();
}
