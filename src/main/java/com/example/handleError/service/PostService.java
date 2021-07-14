package com.example.handleError.service;

import com.example.handleError.dto.PostData;
import com.example.handleError.entity.Post;
import com.example.handleError.entity.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<PostData> list() {
        return PostData.of(postRepository.findAll());
    }
}
