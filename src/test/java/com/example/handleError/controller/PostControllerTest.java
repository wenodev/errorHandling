package com.example.handleError.controller;

import com.example.handleError.dto.PostData;
import com.example.handleError.service.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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

        PostData validPostData = PostData.builder()
                .title(createTitle)
                .content(createContent)
                .build();

        PostData invalidPostData = PostData.builder()
                .title("")
                .content("")
                .build();

        @BeforeEach
        void setUp(){
            given(postService.create(any(PostData.class))).willReturn(validPostData);
        }


        @Nested
        @DisplayName("만약 title과 content가 존재 한다면")
        class Context_with_existed_title_and_content{
            @Test
            @DisplayName("주어진 postData를 저장하고 리턴한다.")
            void it_returns_save_postData_and_return() throws Exception {
                mockMvc.perform(post("/post/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(validPostData)))
                        .andExpect(content().string(containsString(createTitle)))
                        .andExpect(status().isCreated());
            }
        }

        @Nested
        @DisplayName("만약 title과 content가 존재하지 않는다면")
        class Contest_with_not_existed_title_and_content{
            @Test
            @DisplayName("validation message와 badRequest 리턴하라")
            void it_returns_validationMessage_AND_badRequest() throws Exception {
                mockMvc.perform(post("/post/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(invalidPostData)))
                        .andExpect(content().string(containsString("title")))
                        .andExpect(status().isBadRequest());
            }
        }
    }

}
