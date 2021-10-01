package com.example.handleError.service;

import com.example.handleError.dto.PostData;
import com.example.handleError.entity.Post;
import com.example.handleError.repository.PostRepository;
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

    public PostData create(PostData postData) {
        Post post = postRepository.save(PostData.toEntity(postData));
        return PostData.of(post);
    }
}
