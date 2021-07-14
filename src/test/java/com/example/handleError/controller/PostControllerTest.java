package com.example.handleError.controller;

import com.example.handleError.service.PostService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
@DisplayName("PostController 테스트")
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    @Nested
    @DisplayName("list 메소드는")
    class Describe_list{
        @Test
        @DisplayName("Post 전체와 200을 리턴한다.")
        void itReturnAllPostAnd200() throws Exception {
            mockMvc.perform(get("/post/list"))
                    .andExpect(status().isOk());
        }
    }

}
