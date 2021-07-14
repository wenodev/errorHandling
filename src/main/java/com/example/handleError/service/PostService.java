package com.example.handleError.service;

import com.example.handleError.entity.Post;
import com.example.handleError.entity.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post list() {
        return null;
    }
}
