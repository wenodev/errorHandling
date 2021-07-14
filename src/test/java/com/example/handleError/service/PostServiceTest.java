package com.example.handleError.service;

import com.example.handleError.entity.Post;
import com.example.handleError.entity.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;


@DisplayName("PostService 테스트")
class PostServiceTest {

    private PostRepository postRepository = mock(PostRepository.class);
    private PostService postService = new PostService(postRepository);

    @Nested
    @DisplayName("list 메소드는")
    class Describe_list{
        @Test
        @DisplayName("모든 Post를 리턴한다.")
        void It_return_allPost(){
            Post post = postService.list();
        }

    }

}
