package com.example.handleError.controller;

import com.example.handleError.dto.PostData;
import com.example.handleError.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/post")
@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("list")
    public List<PostData> list(){
        return postService.list();
    }
}
