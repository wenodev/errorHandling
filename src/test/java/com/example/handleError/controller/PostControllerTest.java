package com.example.handleError.controller;

import com.example.handleError.dto.PostData;
import com.example.handleError.service.PostService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PostController.class)
@DisplayName("PostController 테스트")
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService postService;

    private ObjectMapper mapper = new ObjectMapper();

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

    @Nested
    @DisplayName("create 메소드는")
    class Describe_create{

        private final static String createTitle = "CREATE_TITLE";
        private final static String createContent = "CREATE_CONTENT";

        PostData postData = PostData.builder()
                .title(createTitle)
                .content(createContent)
                .build();

        @Nested
        @DisplayName("만약 title과 content가 존재 한다면")
        class Context_with_existed_title_and_content{
            @Test
            @DisplayName("주어진 postData를 저장하고 리턴한다.")
            void it_returns_save_postData_and_return() throws Exception {
                mockMvc.perform(post("/post/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(postData)))
                        .andExpect(status().isCreated());
            }
        }
    }

}
