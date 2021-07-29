package com.example.handleError.dto;

import com.example.handleError.entity.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Getter
public class PostData {
    private Long id;

    @NotBlank(message = "title은 필수값 입니다.")
    private String title;

    @NotBlank(message = "content은 필수값 입니다.")
    private String content;

    @Builder
    public PostData(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public static PostData of(Post post){
        return PostData.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .build();
    }

    public static List<PostData> of(List<Post> postList){
        return postList.stream()
                .map(post -> PostData.of(post))
                .collect(Collectors.toList());
    }

    public static Post toEntity(PostData postData){
        return Post.builder()
                .id(postData.getId())
                .title(postData.getTitle())
                .content(postData.getContent())
                .build();
    }

    public static List<Post> toEntity(List<PostData> postDataList){
        return postDataList.stream()
                .map(postData -> postData.toEntity(postData))
                .collect(Collectors.toList());
    }

}

