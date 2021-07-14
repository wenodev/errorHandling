package com.example.handleError.dto;

import lombok.Builder;

import javax.validation.constraints.NotBlank;

public class ProductData {
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public ProductData() {}

    @Builder
    public ProductData(Long id, @NotBlank String title, @NotBlank String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
