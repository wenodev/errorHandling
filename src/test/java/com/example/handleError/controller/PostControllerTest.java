package com.example.handleError.controller;

import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(PostController.class)
@DisplayName("PostController 테스트")
class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

}
