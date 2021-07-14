package com.example.handleError.service;

import com.example.handleError.entity.Post;
import com.example.handleError.entity.PostRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
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
            given(postRepository.findAll()).willReturn(List.of(new Post(1L, "test-title", "test-content")));
            List<Post> postList = postService.list();
            assertThat(postList.get(0).getId()).isEqualTo(1L);
        }
    }
}
