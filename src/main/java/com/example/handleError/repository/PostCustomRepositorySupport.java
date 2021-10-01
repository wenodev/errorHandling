package com.example.handleError.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PostCustomRepositorySupport{

    private final JPAQueryFactory jpaQueryFactory;

    public PostCustomRepositorySupport(JPAQueryFactory jpaQueryFactory) {
        this.jpaQueryFactory = jpaQueryFactory;
    }


}
