package com.example.handleError.controller;

import com.example.handleError.dto.PostData;
import com.example.handleError.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/post")
@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/list")
    public List<PostData> list(){
        return postService.list();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public List<PostData> create(@Valid @RequestBody PostData postData){
        return List.of(PostData.builder()
                .build());
    }
}
