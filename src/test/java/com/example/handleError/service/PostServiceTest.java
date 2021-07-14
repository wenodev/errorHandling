package com.example.handleError.service;

import com.example.handleError.entity.PostRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;


class PostServiceTest {

    private PostRepository postRepository = mock(PostRepository.class);
    private PostService postService = new PostService(postRepository);

    @Test
    void testList(){

    }
}
