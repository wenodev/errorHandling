package com.example.handleError.comparison;

import com.example.handleError.entity.Comment;
import com.example.handleError.entity.Post;
import com.example.handleError.repository.CommentCustomRepository;
import com.example.handleError.repository.CommentRepository;
import com.example.handleError.repository.PostCustomRepository;
import com.example.handleError.repository.PostRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class ComparisonTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentCustomRepository commentCustomRepository;

    private List<Comment> comments = new ArrayList<>();

    @BeforeEach
    void setUp(){
        System.out.println(">>> insert");
        for (int i=0; i<5; i++){
            Post post = Post.builder()
                    .content("hello " + i)
                    .build();
            postRepository.save(post);

            for (int j=0; j<5; j++){
                Comment comment = Comment.builder()
                        .content("hello-comment " + i + " " + j)
                        .post(post)
                        .build();

                comments.add(comment);
            }
            commentRepository.saveAll(comments);
        }
    }

    @Test
    void test_namedJpa(){
        System.out.println(">>> test_namedJpa");
        List<Comment> comments = commentRepository.findAll();
        comments.stream().forEach(comment -> System.out.println(comment));
    }

    @Test
    void test_queryDsl_innerJoin(){
        System.out.println(">>> test_queryDsl");
        List<Comment> comments = commentCustomRepository.innerJoin();
        comments.stream().forEach(comment -> System.out.println(comment));
    }

    @Test
    void test_queryDsl_fetchJoin(){
        System.out.println(">>> test_queryDsl");
        List<Comment> comments = commentCustomRepository.fetchJoin();
        comments.stream().forEach(comment -> System.out.println(comment));
    }

}
