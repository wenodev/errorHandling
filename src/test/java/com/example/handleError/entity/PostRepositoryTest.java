package com.example.handleError.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Transactional
@SpringBootTest
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @BeforeEach
    void setUp(){
        postRepository.saveAll(
                List.of(
                        Post.builder()
                                .title("title-1")
                                .content("content-1")
                                .createdAt(LocalDateTime.now().minusDays(2L))
                                .build(),
                        Post.builder()
                                .title("title-2")
                                .content("content-2")
                                .createdAt(LocalDateTime.now())
                                .build(),
                        Post.builder()
                                .title("title-3")
                                .content("content-3")
                                .createdAt(LocalDateTime.now())
                                .build(),
                        Post.builder()
                                .title("title-2")
                                .content("content-2")
                                .createdAt(LocalDateTime.now())
                                .build(),
                        Post.builder()
                                .title("title-2")
                                .content("content-2")
                                .createdAt(LocalDateTime.now())
                                .build()
                )
        );
    }


    @Test
    void test_select(){

//        facts
//        1. 조회커리 종류 : find, get, read, query, search, stream
//        2. find 다음에 들어오는 단어는 커스터 마이징이 가능하다.
//        findings
//        1. 유니크한 값은 Optional로 reutrn, 중복가능한 값은 List로 return 해야한다.

//        한개 칼럼 조회
//        System.out.println(postRepository.findById(1L));
//        System.out.println(postRepository.getByTitle("title-2"));
//        System.out.println(postRepository.readByTitle("title-1"));
//        System.out.println(postRepository.findPostByTitle("title-1"));
//        System.out.println(postRepository.findWenoByTitle("title-1"));


//        1. Top, First + 숫자 조합으로 조회하면 limit + 숫자 조합의 where절이 실행된다.
        // limit 조회
//        System.out.println(postRepository.findTop2ByTitle("title-2"));
//        System.out.println(postRepository.findFirst2ByTitle("title-2"));

        // last는 존재하지 않기 때문에 findByTitle이 실행된다.
//        System.out.println(postRepository.findLast2ByTitle("title-2"));


//        1. where 절에 and, or 과 limit을 같이 쓸 수 있다.
        // 2개 이상 컬럼 조회
//        System.out.println(postRepository.findByTitleAndContent("title-2", "content-2"));
//          System.out.println(postRepository.findTop2ByTitleAndContent("title-2", "content-2"));
//        System.out.println(postRepository.findByTitleOrContent("title-1", "content-3"));


//        1. 주로 날짜 비교할 때 사용하면 좋다
//        2. After, GreaterThatn은 초과 GreaterThanEqual은 이상
        // 대소비교
//        System.out.println(postRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
//        System.out.println(postRepository.findByIdAfter(2L));
//        System.out.println(postRepository.findByIdGreaterThan(2L));
//        System.out.println(postRepository.findByIdGreaterThanEqual(2L));

        System.out.println(postRepository.findByIdBetween(1L, 2L));
   }

}
