package com.example.handleError.service;

import com.example.handleError.dto.PostData;
import com.example.handleError.entity.Post;
import com.example.handleError.entity.PostRepository;
import org.junit.jupiter.api.BeforeEach;
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

    private final Long EXISTED_ID = 1L;
    private final String EXISTED_TITLE = "existed-title";
    private final String EXISTED_CONTENT = "existed-content";
    private final Post EXISTED_POST = Post.builder()
            .id(EXISTED_ID)
            .title(EXISTED_TITLE)
            .content(EXISTED_CONTENT)
            .build();

    private final PostData EXISTED_POST_DATA = PostData.of(EXISTED_POST);

    @Nested
    @DisplayName("list 메소드는")
    class Describe_list{

        @BeforeEach
        void setUp(){
            given(postRepository.findAll()).willReturn(List.of(EXISTED_POST));
        }

        @Test
        @DisplayName("모든 Post를 리턴한다.")
        void It_return_allPost(){
            List<PostData> postList = postService.list();
            assertThat(postList.get(0).getId()).isEqualTo(1L);
        }
    }

    @Nested
    @DisplayName("create 메소드는")
    class Describe_create{

        private final Long NEW_ID = 2L;
        private final String NEW_TITLE = "new-title";
        private final String NEW_CONTENT = "new-content";
        private final PostData NEW_POST_DATA = PostData.builder()
                .id(NEW_ID)
                .title(NEW_TITLE)
                .content(NEW_CONTENT)
                .build();

        @Test
        @DisplayName("postdata 저장하고 저장된 post와 201을 리턴한다.")
        void it_save_postData_returns_post_and_201(){
            PostData postData = postService.create(NEW_POST_DATA);
            assertThat(postData.getTitle()).isEqualTo(NEW_TITLE);
        }

    }



}
