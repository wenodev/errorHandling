package com.example.handleError.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> getByTitle(String title);

    List<Post> readByTitle(String title);

    List<Post> findPostByTitle(String title);

    List<Post> findWenoByTitle(String title);

    List<Post> findTop2ByTitle(String title);

    List<Post> findFirst2ByTitle(String title);

    List<Post> findLast2ByTitle(String title);

    List<Post> findByTitleAndContent(String title, String content);

    List<Post> findTop2ByTitleAndContent(String title, String content);

    List<Post> findByTitleOrContent(String title, String content);

    List<Post> findByCreatedAtAfter(LocalDateTime dateTime);

    List<Post> findByIdAfter(Long id);

    List<Post> findByIdGreaterThan(Long id);

    List<Post> findByIdGreaterThanEqual(Long id);

    List<Post> findByIdBetween(Long id1, Long id2);
}
